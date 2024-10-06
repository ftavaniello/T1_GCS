import java.util.ArrayList;

public class Departamento {
    private String nome;
    private ArrayList<Usuario> usuario;

    public Departamento (String nome, ArrayList<Usuario> usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento{");
        sb.append("nome=").append(nome);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }
}
