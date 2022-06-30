package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import com.example.fingeso.models.VerDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepositoryImp implements UserRepository{
    @Autowired
    private Sql2o sql2o;
    /*
    D: Funcion que obtiene el numero de usuarios en la base de datos mediante una consulta
    I: void
    O: Numero de usuarios (Entero)
    */
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
    /*
    D: Funcion que obtiene todos los usarios de la base de datos mediante una consulta
    I: void
    O: Lista de Objeto usuario
    */
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
    /*
    D: Funcion que obtiene a usarios de la base de datos mediante una consulta a traves de su rol
    I: rol usuario (Entero)
    O: Lista de Objeto usuario
    */
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
    /*
    D: Funcion que obtiene a un usario de la base de datos mediante una consulta a traves de su correo
    I: mail usuario (String)
    O: Lista de Objeto usuario
    */
    @Override
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
    /*
    D: Funcion que obtiene a un usario de la base de datos mediante una consulta a traves de su id
    I: id usuario (Entero)
    O: Lista de Objeto usuario
    */
    @Override
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
    /*
    D: Funcion que inserta en la base de datos un nuevo usuario
    I: Objeto usuario
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
    */
    @Override
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
    /*
    D: Funcion que autentica a un usuario mediante su correo y contraseña
    I: Mail y password (String)
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
    */
    @Override
    public Integer autenticacion(String mail, String pass){
        List<User> users = getByEmail(mail);
        if(users.isEmpty()){
            return -1;
        }
        User user = users.get(0);
        String contrasenia = user.getContrasenia();
        if(contrasenia.equals(pass)){
            System.out.println("Logeado Correctamente");
            return 0;
        }else{
            System.out.println("Credenciales Inválidas");
            return -1;
        }
    }
    /*
    D: Funcion que determina un fiscal al azhar dentro de los disponibles
    I: id Usuario, id Rol
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
    */
    public Integer updateRolUser(Integer id_usuario, Integer id_rol){
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
    /*
    D: Funcion que determina un fiscal al azhar dentro de los disponibles
    I: void
    O: Entero que simboliza el fiscal asignado
    */
    public Integer seleccionarFiscal(){
        final String query = "SELECT * FROM usuario WHERE id_rol = '" + 1 + "'";
        final List<User> fiscales;
        Connection conn = sql2o.open();
        try( conn ){
            fiscales = conn.createQuery(query).executeAndFetch(User.class);
            Random aleatorio = new Random();
            User usuario = fiscales.get(aleatorio.nextInt(fiscales.size()));
            Integer rol = usuario.getId();
            return rol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }
    /*
    D: Funcion que filtra a todos los usuarios que no tengan rol de admin, devuelve una lista con estos
    I: void
    O: null: no hay usuarios, lista: usuarios sin admin
    */
    public List<User> getAllUsersNoAdmin(){
        List <User> users = getAllUsers();
        List <User> normalUsers = new ArrayList<User>();
        if(users.isEmpty()){    // Si no hay usuarios
            System.out.println ("No hay usuarios");
            return null;
        }
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getRol() == 3){ // Si tiene el rol de admin se ignora
                continue;
            }
            else{   // si no, se añade a una lista auxiliar
                normalUsers.add(users.get(i));
            }
        }
        return normalUsers;
    }
}

