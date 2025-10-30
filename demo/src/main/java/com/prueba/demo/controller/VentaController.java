package com.prueba.demo.controller;

import com.prueba.demo.entity.Venta;
import com.prueba.demo.services.ClienteService;
import com.prueba.demo.services.ProductoService;
import com.prueba.demo.services.VentaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;
    private final ProductoService productoService;
    private final ClienteService clienteService;

    public VentaController(VentaService ventaService, ProductoService productoService, ClienteService clienteService) {
        this.ventaService = ventaService;
        this.productoService = productoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaService.listarVentas());
        return "ventas";
    }

    @GetMapping("/nueva")
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public String mostrarFormularioVenta(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("clientes", clienteService.listarClientes());
        return "venta_form";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public String guardarVenta(@ModelAttribute Venta venta) {

        var producto = productoService.buscarPorId(venta.getProducto().getId());

        var cliente = clienteService.listarClientes()
                .stream()
                .filter(c -> c.getId().equals(venta.getCliente().getId()))
                .findFirst()
                .orElse(null);

        venta.setProducto(producto);
        venta.setCliente(cliente);
        venta.setFecha(new java.util.Date());

        ventaService.guardarVenta(venta);

        return "redirect:/ventas";
    }

}


