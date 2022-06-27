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
    public Boolean verificaCorreo(String correo, String nombre, String apellido1){
        List<User> users = this.userRepository.getByEmail(correo);
        if(users.isEmpty()){
            return false;
        }
        User user = users.get(0);
        String nombreReal = user.getNombre();
        String apellido1Real = user.getApellidos();
        if(nombreReal.equals(nombre) && apellido1Real.equals(apellido1)){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Se ingresa la denuncia verificando si el correo y los nombre y apellido ingresados existen
     */
    public Integer crearDenuncia(IngresarDenuncia denuncia){
        String[] splited1 = denuncia.getApellido1().split("\\s+");
        String[] splited2 = denuncia.getApellido2().split("\\s+");
        if(splited1.length == 1) {
            splited1[1]="";
        }
        if(splited2.length == 1) {
            splited2[1]="";
        }
        String mixApellidos1 =splited1[0]+splited1[1];
        String mixApellidos2 =splited2[0]+splited2[1];
        System.out.println(mixApellidos1);
        System.out.println(mixApellidos2);
        if(verificaCorreo(denuncia.getMail1(),denuncia.getNombre1(),mixApellidos1) &&
                verificaCorreo(denuncia.getMail2(),denuncia.getNombre2(),mixApellidos2)){
            String mail = denuncia.getMail1();
            String mail2 = denuncia.getMail2();
            if(mail.equals(mail2)){
                System.out.println("No está permitido que una persona se autodenuncie");
                return 0;
            }
            List <User> usuario = userRepository.getByEmail(mail);
            List <User> usuario2 = userRepository.getByEmail(mail2);
            User user1 = usuario.get(0);
            User user2 = usuario2.get(0);
            Integer usuarioId = user1.getId();
            Integer usuarioId2 = user2.getId();
            Denuncia newDen = new Denuncia(countDenuncias(),usuarioId,usuarioId2,user1.getEstamento(),denuncia.getDescrip(),denuncia.getMedidas(),0,0);
            postDenuncia(newDen);
            System.out.println("Denuncia Ingresada Correctamente");
            return 1;
        }
        else{
            System.out.println("Correos no encontrados");
            return 0;
        }
    }
    /*
    -1 representa ID de estado erroneo
    0 implica que hubo un error
    1 representa una actualizacion exitosa
     */
    @Override
    public Integer updateDenuncia(Integer id_denuncia, Integer id_estado){
        if (!(id_estado.equals(1) || id_estado.equals(2))){
            if(!(id_estado.equals(3))){
                return -1;
            }
        }
        List<Denuncia> verificacion_denuncia = getById(id_denuncia);
        Integer estado_actual = verificacion_denuncia.get(0).getIdEstado();
        if(estado_actual == 3 || estado_actual > id_estado){
            return -1;
        }
        final String query =  "update denuncia set id_estado = :id_estado where id_denuncia = :id_denuncia";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter( "id_denuncia", id_denuncia)
                    .addParameter("id_estado", id_estado)
                    .executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }
}