package com.prueba.demo.controller;

import com.prueba.demo.document.Venta;
import com.prueba.demo.document.Venta.ClienteEmb;
import com.prueba.demo.document.Venta.VendedorEmb;
import com.prueba.demo.document.Venta.DetalleVentaEmb;

import com.prueba.demo.services.ClienteService;
import com.prueba.demo.services.ProductoService;
import com.prueba.demo.services.UsuarioService;
import com.prueba.demo.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public String listar(Model model) {
        List<Venta> ventas = ventaService.listarVentas();
        model.addAttribute("ventas", ventas);
        return "ventas";
    }

    @GetMapping("/nueva")
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public String nuevaVenta(Model model) {

        model.addAttribute("productos", productoService.listar());
        model.addAttribute("clientes", clienteService.listar());

        var usuarioActual = usuarioService.obtenerUsuarioAutenticado();
        model.addAttribute("usuario", usuarioActual);

        return "venta_form";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public String guardarVenta(@ModelAttribute Venta venta,
                               @RequestParam String clienteId) {

        var cliente = clienteService.buscarPorId(clienteId);
        ClienteEmb clienteEmb = new ClienteEmb();
        clienteEmb.setId(cliente.getId());
        clienteEmb.setNombre(cliente.getNombre());
        venta.setCliente(clienteEmb);

        var vendedor = usuarioService.obtenerUsuarioAutenticado();
        VendedorEmb vendedorEmb = new VendedorEmb();
        vendedorEmb.setId(vendedor.getId());
        vendedorEmb.setNombre(vendedor.getUsername());
        venta.setVendedor(vendedorEmb);

        if (venta.getDetalles() != null) {
            for (DetalleVentaEmb detalle : venta.getDetalles()) {
                if (detalle.getProductoId() != null && detalle.getCantidad() > 0) {
                    productoService.reducirStock(detalle.getProductoId(), detalle.getCantidad());
                }
            }
        }

        venta.setFecha(new Date());
        ventaService.guardarVenta(venta);

        return "redirect:/ventas";
    }

}
