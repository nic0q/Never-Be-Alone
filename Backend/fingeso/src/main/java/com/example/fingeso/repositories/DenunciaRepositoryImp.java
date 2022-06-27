package com.example.fingeso.repositories;
import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.IngresarDenuncia;
import com.example.fingeso.models.User;
import com.example.fingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class DenunciaRepositoryImp implements DenunciaRepository{
    @Autowired
    private Sql2o sql2o;
    private UserRepository userRepository;
    DenunciaRepositoryImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    //@Override
    public int countDenuncias(){
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM DENUNCIA").executeScalar(Integer.class);
            return total;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public List<Denuncia> getAllDenuncias(){
        final String query = "select * from denuncia";
        final List<Denuncia> denuncias;
        Connection conn = sql2o.open();
        try( conn ){
            denuncias = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return denuncias;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    @Override
    public List<Denuncia> getByFiscal(Integer fiscalID){
        // ARREGLAR COLUMNA ID FISCAL
        final String query = "select * from denuncia where id_fiscal = '" + fiscalID +"'";
        final List<Denuncia> denuncias;
        Connection conn = sql2o.open();
        try( conn ){
            denuncias = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return denuncias;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public List<Denuncia> findDenunciaDenunciante(Integer userID){
        final String query = "select * from denuncia where id_denunciante = '" + userID + "'";
        final List<Denuncia> denuncias;
        Connection conn = sql2o.open();
        try( conn ){
            denuncias = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return denuncias;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    @Override
    public List<Denuncia> findDenunciaDenunciado(Integer userID){

        final String query = "select * from denuncia where id_denunciado = '" + userID + "'";
        final List<Denuncia> denuncias;
        Connection conn = sql2o.open();
        try( conn ){
            denuncias = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return denuncias;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    /*
     * Se establece codigos de validez
     * 0 : correcto ingreso
     * 1: error en correo denunciante
     * 2: error en correo denunciado
     * -1: error al ingreso en la base de datos
     * */
    @Override
    public Integer postDenuncia(@RequestBody Denuncia denuncia){
        Connection conn = sql2o.open();
        int total = countDenuncias();
        final String query = "insert into denuncia (id_denuncia,id_denunciante,id_denunciado,id_estamento_denunciado,descripcion,medidas,id_estado)"+
                "values (:id_denuncia,:id_denunciante, :id_denunciado, :id_estamento_denunciado, :descripcion, :medidas, :id_estado)";
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id_denuncia",total)
                    .addParameter("id_denunciante",denuncia.getIdDenunciante())
                    .addParameter("id_denunciado",denuncia.getIdDenunciado())
                    .addParameter("id_estamento_denunciado",denuncia.getIdEstamentoDenunciado())
                    .addParameter("descripcion",denuncia.getDescripcion())
                    .addParameter("medidas",denuncia.getMedidas())
                    .addParameter("id_estado",denuncia.getIdEstado())
                    .executeUpdate();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally{
            conn.close();
        }
    }
    public List<Denuncia> getByEmail(String email){
        final String query = "SELECT * FROM denuncia WHERE email = '" + email + "'";
        final List<Denuncia> usersMail;
        Connection conn = sql2o.open();
        try( conn ){
            usersMail = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return usersMail;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    public List<Denuncia> getById(Integer id){
        final String query = "SELECT * FROM denuncia WHERE id_denuncia = '" + id + "'";
        final List<Denuncia> usersRol;
        Connection conn = sql2o.open();
        try( conn ){
            usersRol = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return usersRol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    @Override
    public Boolean verificaCorreo(String correo, String nombre, String apellido1, String apellido2){
        List<User> users = this.userRepository.getByEmail(correo);
        System.out.println(users.toString());
        User user = users.get(0);
        String nombreReal = user.getNombre();
        String apellido1Real = user.getPrimerApellido();
        String apellido2Real = user.getSegundoApellido();
        if(nombreReal == nombre && apellido1Real == apellido1 && apellido2Real == apellido2){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Se ingresa la denuncia verificando si el correo y los nombre y apellido ingresados existen
     */
    public Integer crearDenuncia(IngresarDenuncia denuncia){
        System.out.println(denuncia.getMail1());
        if(verificaCorreo(denuncia.getMail1(),denuncia.getNombre1(),denuncia.getApellido1(),denuncia.getApellido2())){
            List <Denuncia> a;
            a = getByEmail(denuncia.getMail1());
            if(a == null){
                return 0;
            }
            Denuncia den = a.get(0);
            Denuncia denu = new Denuncia(countDenuncias(),den.getIdDenunciante(),den.getIdDenunciado(),den.getIdEstamentoDenunciado(),den.getDescripcion(),den.getMedidas(),den.getIdEstado(),den.getIdFiscal());
            postDenuncia(denu);
            System.out.println("EXITOSO");
            return 1;
        }
        else{
            System.out.println("FALSO");
            return 0;
        }
    }
}