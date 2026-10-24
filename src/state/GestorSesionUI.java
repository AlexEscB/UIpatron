package state;

import java.util.HashMap;
import java.util.Map;

public class GestorSesionUI {
    private boolean usuarioActivo;
    private Map<String, String> borradorTemporal;
    private Map<String, Boolean> camposCompletados;
    
    public GestorSesionUI() {
        this.usuarioActivo = false;
        this.borradorTemporal = new HashMap<>();
        this.camposCompletados = new HashMap<>();
        // Inicializar campos
        camposCompletados.put("nombre", false);
        camposCompletados.put("telefono", false);
        camposCompletados.put("correo", false);
    }
    
    // Completeness Meter: Calcula el porcentaje de avance
    public int calcularPorcentajeCompletitud() {
        int totalCampos = camposCompletados.size();
        int camposListos = 0;
        
        for (Boolean completado : camposCompletados.values()) {
            if (completado) {
                camposListos++;
            }
        }
        
        if (totalCampos == 0) {
            return 0;
        }
        
        return (int) Math.round((camposListos * 100.0) / totalCampos);
    }
    
    public void mostrarProgreso() {
        int porcentaje = calcularPorcentajeCompletitud();
        int totalCampos = camposCompletados.size();
        int camposListos = 0;
        
        for (Boolean completado : camposCompletados.values()) {
            if (completado) {
                camposListos++;
            }
        }
        
        StringBuilder faltantes = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : camposCompletados.entrySet()) {
            if (!entry.getValue()) {
                if (faltantes.length() > 0) {
                    faltantes.append(", ");
                }
                // Convertir a nombre legible
                String nombreCampo = entry.getKey();
                if (nombreCampo.equals("nombre")) {
                    faltantes.append("Nombre");
                } else if (nombreCampo.equals("telefono")) {
                    faltantes.append("Teléfono");
                } else if (nombreCampo.equals("correo")) {
                    faltantes.append("Correo de contacto");
                } else {
                    faltantes.append(nombreCampo);
                }
            }
        }
        
        System.out.print("[Progreso: " + porcentaje + "%] Campos listos: " + camposListos + " de " + totalCampos);
        if (faltantes.length() > 0) {
            System.out.println(" (Falta: " + faltantes.toString() + ")");
        } else {
            System.out.println(" ¡Formulario completo!");
        }
    }
    
    public void marcarCampoCompletado(String campo, boolean completado) {
        if (camposCompletados.containsKey(campo)) {
            camposCompletados.put(campo, completado);
        }
    }
    
    // Lazy Registration
    public boolean guardarReserva() {
        if (!usuarioActivo) {
            // Guardar avance en borrador temporal
            guardarBorrador();
            System.out.println("\n[Lazy Registration] Avance guardado en borrador temporal. Por favor cree su cuenta para finalizar.");
            return false;
        } else {
            // Usuario autenticado, guardar directamente
            mostrarToast("Reserva guardada exitosamente.");
            return true;
        }
    }
    
    private void guardarBorrador() {
        borradorTemporal.put("timestamp", String.valueOf(System.currentTimeMillis()));
        borradorTemporal.put("estado", "pendiente_registro");
        System.out.println("[Borrador guardado con éxito]");
    }
    
    public void completarRegistro() {
        this.usuarioActivo = true;
        System.out.println("Usuario completa registro rápido -> Sesión activa = true");
        // Al autenticarse, puede finalizar el guardado
        mostrarToast("Reserva guardada exitosamente.");
    }
    
    // Toast notification
    public void mostrarToast(String mensaje) {
        System.out.println("\n[Toast de Estado] " + mensaje);
    }
    
    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }
    
    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
    
    public Map<String, String> getBorradorTemporal() {
        return borradorTemporal;
    }
}
