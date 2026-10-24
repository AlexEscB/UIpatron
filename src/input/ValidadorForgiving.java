package input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorForgiving {
    
    public String limpiarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return "";
        }
        
        // Forgiving Format: Acepta cualquier formato (espacios, paréntesis, guiones o +57)
        // y normaliza internamente sin arrojar errores al usuario
        String resultado = telefono;
        
        // Eliminar prefijo +57 al inicio
        resultado = resultado.replaceAll("^\\+57\\s*", "");
        resultado = resultado.replaceAll("^57\\s*", "");
        
        // Eliminar todos los caracteres que no sean dígitos
        resultado = resultado.replaceAll("[^0-9]", "");
        
        return resultado;
    }
    
    public String limpiarFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            return "";
        }
        
        String resultado = fecha;
        // Mantener solo dígitos para normalización
        resultado = resultado.replaceAll("[^0-9]", "");
        return resultado;
    }
    
    public boolean esTelefonoValido(String telefonoLimpio) {
        if (telefonoLimpio == null || telefonoLimpio.isEmpty()) {
            return false;
        }
        // Validación básica: debe tener al menos 7 dígitos
        return telefonoLimpio.matches("\\d{7,10}");
    }
}
