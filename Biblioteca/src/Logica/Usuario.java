package Logica;

public class Usuario {
    private String nombreUsuario;
    private String clave;
    private String rol;

    public Usuario(String nombreUsuario, String clave, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
