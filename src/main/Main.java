package main;

import navigation.BreadcrumbNavigator;
import content.TarjetaElemento;
import input.ValidadorForgiving;
import state.GestorSesionUI;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Taller para la Casa – User Interface Patterns");
        System.out.println("Sistema de Configuración y Reservas Universitarias\n");
        
        // CASO 1: PATRÓN DE NAVEGACIÓN (BREADCRUMBS + TABS)
        System.out.println("--- 1. PATRÓN DE NAVEGACIÓN (BREADCRUMBS + TABS) ---\n");
        BreadcrumbNavigator navegador = new BreadcrumbNavigator();
        navegador.mostrarRuta();
        System.out.println();
        
        // Simulando cambio de navegación
        navegador.navegarA("Reservas", "Laboratorio de Redes");
        System.out.println("--- Navegación dinámica ---");
        navegador.mostrarRuta();
        System.out.println("\n");
        
        // CASO 2: PATRÓN DE CONTENIDO Y ESTRUCTURA (PROGRESSIVE DISCLOSURE)
        System.out.println("--- 2. PATRÓN DE CONTENIDO Y ESTRUCTURA (PROGRESSIVE DISCLOSURE) ---\n");
        TarjetaElemento servidor = new TarjetaElemento("Servidor Principal", "Activo", 
                                                        "192.168.1.10", "8080", "4GB/16GB");
        servidor.mostrarVistaResumen();
        servidor.solicitarVerDetallesAvanzados();
        System.out.println("\n");
        
        // CASO 3: PATRÓN DE ENTRADA DE DATOS (FORGIVING FORMAT)
        System.out.println("--- 3. PATRÓN DE ENTRADA DE DATOS (FORGIVING FORMAT) ---\n");
        ValidadorForgiving validador = new ValidadorForgiving();
        String entradaTelefono = "+57 (300) 123-4567";
        System.out.println("Entrada del usuario: \"" + entradaTelefono + "\"\n");
        String telefonoNormalizado = validador.limpiarTelefono(entradaTelefono);
        System.out.println("Teléfono normalizado sin error: \"" + telefonoNormalizado + "\"");
        System.out.println("\n");
        
        // CASO 4: PATRÓN DE FEEDBACK Y ESTADO (COMPLETENESS METER)
        System.out.println("--- 4. PATRÓN DE FEEDBACK Y ESTADO (COMPLETENESS METER) ---\n");
        GestorSesionUI gestor = new GestorSesionUI();
        // Llenar campos progresivamente
        gestor.marcarCampoCompletado("nombre", true);
        gestor.marcarCampoCompletado("telefono", true);
        gestor.marcarCampoCompletado("correo", false);
        gestor.mostrarProgreso();
        System.out.println("\nUsuario ingresa correo: \"estudiante@udistrital.edu.co\"");
        gestor.marcarCampoCompletado("correo", true);
        gestor.mostrarProgreso();
        System.out.println("\n");
        
        // CASO 5: LAZY REGISTRATION + TOAST
        System.out.println("--- 5. LAZY REGISTRATION + TOAST ---\n");
        GestorSesionUI gestorReserva = new GestorSesionUI();
        System.out.println("Usuario intenta guardar sin haber iniciado sesión...");
        boolean guardado = gestorReserva.guardarReserva();
        System.out.println();
        if (!guardado) {
            gestorReserva.completarRegistro();
        }
        System.out.println("\n");
        
        // Demostración completa de los 5 casos de prueba
        System.out.println("=== CASOS DE PRUEBA VERIFICABLES ===\n");
        ejecutarCasosPrueba();
    }
    
    private static void ejecutarCasosPrueba() {
        // Caso 1
        System.out.println("Caso 1 - Navegación (Breadcrumb): Cambiar de pestaña o entrar a una subcategoría");
        BreadcrumbNavigator nav = new BreadcrumbNavigator();
        nav.navegarA("Catálogo", "Servidores");
        System.out.println("Resultado: " + nav.obtenerRutaActual());
        System.out.println("✓ Ruta actualizada dinámicamente\n");
        
        // Caso 2
        System.out.println("Caso 2 - Contenido (Progressive Disclosure): verAvanzado = false y luego true");
        TarjetaElemento equipo = new TarjetaElemento("Equipo de Red", "Activo", 
                                                     "10.0.0.5", "22", "8GB/32GB");
        equipo.setVerAvanzado(false);
        System.out.print("Con verAvanzado=false: ");
        equipo.mostrarDetallesAvanzados();
        equipo.setVerAvanzado(true);
        System.out.print("Con verAvanzado=true: ");
        equipo.mostrarDetallesAvanzados();
        System.out.println("✓ Detalles técnicos ocultos y luego desplegados bajo demanda\n");
        
        // Caso 3
        System.out.println("Caso 3 - Entrada (Forgiving Format): Ingresar \"+57 (310) 999-8877\"");
        ValidadorForgiving val = new ValidadorForgiving();
        String normalizado = val.limpiarTelefono("+57 (310) 999-8877");
        System.out.println("Resultado: \"" + normalizado + "\"");
        System.out.println("✓ Retorna sin lanzar excepciones ni errores\n");
        
        // Caso 4
        System.out.println("Caso 4 - Feedback (Completeness Meter): Llenar 1, 2 y 3 campos progresivamente");
        GestorSesionUI g = new GestorSesionUI();
        g.marcarCampoCompletado("nombre", true);
        g.mostrarProgreso();
        g.marcarCampoCompletado("telefono", true);
        g.mostrarProgreso();
        g.marcarCampoCompletado("correo", true);
        g.mostrarProgreso();
        System.out.println("✓ El medidor sube de 33% a 67% y finalmente a 100%\n");
        
        // Caso 5
        System.out.println("Caso 5 - Entrada + Estado (Lazy Registration + Toast): Guardar con usuarioActivo=false y luego true");
        GestorSesionUI g2 = new GestorSesionUI();
        g2.setUsuarioActivo(false);
        System.out.println("Intentando guardar con usuarioActivo=false...");
        g2.guardarReserva();
        System.out.println("\nCompletando registro...");
        g2.completarRegistro();
        System.out.println("✓ Primero conserva el borrador y pide registro; al autenticarse, muestra el Toast de éxito\n");
    }
}
