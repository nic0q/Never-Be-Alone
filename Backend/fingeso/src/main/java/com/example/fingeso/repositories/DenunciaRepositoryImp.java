package com.example.fingeso.repositories;
import com.example.fingeso.models.Denuncia;
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

    @Override
    public Boolean verificaCorreo(String correo, String nombre, String apellido1, String apellido2){
        List<User> users = userRepository.getByEmail(correo);
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

    @Override
    public Integer updateDenuncia(Integer id_denuncia, Integer id_estado){
        if (id_estado.equals(0) || id_estado.equals(3)){
            return -1;
        }
        final String query = "update denuncia set id_estado = '" + id_estado + "'where id_denuncia = '" + id_denuncia + "'";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id_estado", id_estado)
                    .addParameter("id_denuncia", id_denuncia)
                    .executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -9;
        }
        finally {
            conn.close();
        }
    }
}