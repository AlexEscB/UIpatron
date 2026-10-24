package content;

public class TarjetaElemento {
    private String nombre;
    private String estado;
    private String ip;
    private String puerto;
    private String ram;
    private boolean verAvanzado;

    public TarjetaElemento(String nombre, String estado, String ip, String puerto, String ram) {
        this.nombre = nombre;
        this.estado = estado;
        this.ip = ip;
        this.puerto = puerto;
        this.ram = ram;
        this.verAvanzado = false; // Oculto por defecto
    }

    public void mostrarVistaResumen() {
        System.out.println("[Vista Resumen] " + nombre + " · Estado: " + estado);
    }

    public void solicitarVerDetallesAvanzados() {
        System.out.println("\n[Usuario solicita ver detalles avanzados...]");
        this.verAvanzado = true;
        mostrarDetallesAvanzados();
    }

    public void mostrarDetallesAvanzados() {
        if (verAvanzado) {
            System.out.println("[Acordeón Desplegado] IP: " + ip + " | Puerto: " + puerto + " | RAM: " + ram);
        } else {
            System.out.println("[Acordeón Colapsado] Los detalles técnicos permanecen ocultos.");
        }
    }

    public void ocultarDetallesAvanzados() {
        this.verAvanzado = false;
        System.out.println("[Acordeón Colapsado] Los detalles técnicos han sido ocultados.");
    }

    public boolean isVerAvanzado() {
        return verAvanzado;
    }

    public void setVerAvanzado(boolean verAvanzado) {
        this.verAvanzado = verAvanzado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }
}
