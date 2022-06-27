package com.example.fingeso.repositories;
import com.example.fingeso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countUsers(){
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM usuario").executeScalar(Integer.class);
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
    public List<User> getAllUsers(){
        final String query = "select * from usuario";
        final List<User> usersTotal;
        Connection conn = sql2o.open();
        try( conn ){
            usersTotal = conn.createQuery(query).executeAndFetch(User.class);
            return usersTotal;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    @Override
    public List<User> getByRol(Integer rol){
        final String query = "SELECT * FROM usuario WHERE id_rol = '" + rol + "'";
        final List<User> usersRol;

        Connection conn = sql2o.open();
        try( conn ){
            usersRol = conn.createQuery(query).executeAndFetch(User.class);
            return usersRol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    public List<User> getByEmail(String email){
        final String query = "SELECT * FROM usuario WHERE email = '" + email + "'";
        final List<User> usersMail;
        Connection conn = sql2o.open();
        try( conn ){
            usersMail = conn.createQuery(query).executeAndFetch(User.class);
            return usersMail;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    public List<User> getById(Integer id){
        final String query = "SELECT * FROM usuario WHERE id_usuario = '" + id + "'";
        final List<User> usersRol;
        Connection conn = sql2o.open();
        try( conn ){
            usersRol = conn.createQuery(query).executeAndFetch(User.class);
            return usersRol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    // Returns
    // 0: Exito
    // -1: Fallido
    public Integer postUser(@RequestBody User user){
        Connection con = sql2o.open();
        final String query  =
                "insert into usuario (id_usuario,email,nombre,apellidos,password,id_rol,id_estamento)"+
                "VALUES (:id_usuario, :email,:nombre,:apellidos,:password,:id_rol,:id_estamento)";
        int total = countUsers();
        try ( con ) {
            con.createQuery(query)
                    .addParameter("id_usuario", total)
                    .addParameter("email", user.getCorreo())
                    .addParameter("nombre",user.getNombre())
                    .addParameter("apellidos",user.getApellidos())
                    .addParameter("password", user.getContrasenia())
                    .addParameter("id_rol",user.getRol())
                    .addParameter("id_estamento",user.getEstamento())
                    .executeUpdate();
            return 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            con.close();
        }
    }

    public Boolean autenticacion(String correo, String pass){
        List<User> users = getByEmail(correo);
        if(users.isEmpty()){
            return false;
        }
        User user = users.get(0);
        String contrasenia = user.getContrasenia();
        if(contrasenia == pass){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int updateRolUser(Integer id_usuario, Integer id_rol){

        //final String query = "update usuario set id_rol = '" + id_rol + "' where id_usuario = '" + id_usuario + "'";
        final String query = "update usuario set id_rol = :id_rol where id_usuario = :id_usuario";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id_rol", id_rol)
                    .addParameter("id_usuario", id_usuario)
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
}

