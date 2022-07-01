package com.example.fingeso.repositories;

import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.IngresarDenuncia;
import com.example.fingeso.models.VerDenuncia;
import com.example.fingeso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DenunciaRepositoryImp implements DenunciaRepository{
    @Autowired
    private Sql2o sql2o;
    private UserRepository userRepository;
    private EstamentoRepository estamentoRepository;
    private EstadoRepository estadoRepository;
    DenunciaRepositoryImp(UserRepository userRepository, EstamentoRepositoryImp estamentoRepository, EstadoRepositoryImp estadoRepository){
        this.userRepository=userRepository;
        this.estamentoRepository=estamentoRepository;
        this.estadoRepository = estadoRepository;
    }
    /*
    D: Funcion que obtiene el numero de denucias en la base de datos mediante una consulta
    I: void
    O: Numero de denuncias (Entero)
    */
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
    /*
    D: Funcion que obtiene todos las denucias de la base de datos mediante una consulta
    I: void
    O: Lista de Objeto denuncia
    */
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
    /*
    D: Funcion que busca y entrega una denuncia en base al id del fiscal
    I: id fiscal (Entero)
    O: Lista de Objeto Denuncia
    */
    @Override
    public List<Denuncia> getByFiscal(Integer fiscalID){
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
    /*
    D: Funcion que busca y entrega una denuncia en base al id del denunciante
    I: id denunciante (Entero)
    O: Lista de Objeto Denuncia
    */
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
    /*
    D: Funcion que busca y entrega una denuncia en base al id del denunciado
    I: id denunciado (Entero)
    O: Lista de Objeto Denuncia
    */
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
    D: Funcion que ingresa una denuncia a la base de datos
    I: Objeto denuncia
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
    */
    @Override
    public Integer postDenuncia(Denuncia denuncia){
        Connection conn = sql2o.open();
        int total = countDenuncias();
        final String query = "insert into denuncia (id_denuncia,id_denunciante,id_denunciado,id_estamento_denunciado,descripcion,medidas,id_estado,fecha, id_fiscal)"+
                "values (:id_denuncia,:id_denunciante, :id_denunciado, :id_estamento_denunciado, :descripcion, :medidas, :id_estado, :fecha, :id_fiscal)";
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id_denuncia",total)
                    .addParameter("id_denunciante",denuncia.getIdDenunciante())
                    .addParameter("id_denunciado",denuncia.getIdDenunciado())
                    .addParameter("id_estamento_denunciado",denuncia.getIdEstamentoDenunciado())
                    .addParameter("descripcion",denuncia.getDescripcion())
                    .addParameter("medidas",denuncia.getMedidas())
                    .addParameter("id_estado",denuncia.getIdEstado())
                    .addParameter("fecha",denuncia.getFecha())
                    .addParameter("id_fiscal",denuncia.getIdFiscal())
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
    D: Funcion que obtiene a una denuncia de la base de datos mediante una consulta a traves del correo denunciante
    I: mail denunciante (String)
    O: Lista de Objeto denuncia
    */
    @Override
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
    /*
    D: Funcion que obtiene a una denuncia de la base de datos mediante una consulta a traves de su id
    I: id denuncia (Entero)
    O: Lista de Objeto denuncia
    */
    @Override
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
    /*
    D: Funcion que verifica si nombre, apellido y correo coinciden con un usuario de la base de datos
    I: correoE, nombre, apellido (String,String,String)
    O: boolean
    */
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
    /*
    D: Funcion que da el formato para ingresar una nueva denuncia
    I: Objeto denuncia
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
    */
    @Override
    public Integer crearDenuncia(IngresarDenuncia denuncia){
        String mixApellidos1 = denuncia.getApellido11()+denuncia.getApellido12();
        String mixApellidos2 = denuncia.getApellido21()+denuncia.getApellido22();
        if(verificaCorreo(denuncia.getMail1(),denuncia.getNombre1(),mixApellidos1) &&
                verificaCorreo(denuncia.getMail2(),denuncia.getNombre2(),mixApellidos2)){
            String mail = denuncia.getMail1();
            String mail2 = denuncia.getMail2();
            if(mail.equals(mail2)){
                System.out.println("No está permitido que una persona se autodenuncie");
                return -1;
            }
            List <User> usuario = userRepository.getByEmail(mail);
            List <User> usuario2 = userRepository.getByEmail(mail2);
            User user1 = usuario.get(0);
            User user2 = usuario2.get(0);
            Integer usuarioId = user1.getId();
            Integer usuarioId2 = user2.getId();
            if(denuncia.getEstamento() != user2.getEstamento()){
                System.out.println("Estamento invalido");
                return -1;
            }
            Denuncia newDen = new Denuncia(countDenuncias(),usuarioId,usuarioId2,user1.getEstamento(),denuncia.getDesc(),denuncia.getMedidas(),0,userRepository.seleccionarFiscal());
            postDenuncia(newDen);
            System.out.println("Denuncia Ingresada Correctamente");
            return 0;
        }
        else{
            System.out.println("Correos no encontrados");
            return -1;
        }
    }
    /*
    D: Funcion que acutaliza el estado de una denuncia
    I: id denuncia, id estado (Entero,Entero)
    O: Entero que simboliza si hubo exito o fallo 0: Exito, -1: Fallo
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
            System.out.println("No es posible actualizar la denuncia");
            return -1;
        }
        final String query =  "update denuncia set id_estado = :id_estado where id_denuncia = :id_denuncia";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter( "id_denuncia", id_denuncia)
                    .addParameter("id_estado", id_estado)
                    .executeUpdate();
            System.out.println("Denuncia Actualizada Correctamente");
            return 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }
    /*
    D: Funcion que obtiene las denuncias que un usuario ha realizado
    I: id denuncia (Entero)
    O: Lista Denuncias
    */
    @Override
    public List<VerDenuncia>showDenunciaRealizada(Integer idDenuncia){
        List <Denuncia> denuncia = findDenunciaDenunciante(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<>();
        for(int i = 0; i < denuncia.size();i++){
            Denuncia den = denuncia.get(i);
            Integer id = denuncia.get(i).getIdDenuncia();
            String name1 = userRepository.getById(den.getIdDenunciante()).get(0).getNombre();
            String apellidos1 = userRepository.getById(den.getIdDenunciante()).get(0).getApellidos();
            String mail1 = userRepository.getById(den.getIdDenunciante()).get(0).getCorreo();
            String name2 = userRepository.getById(den.getIdDenunciado()).get(0).getNombre();
            String apellidos2 = userRepository.getById(den.getIdDenunciado()).get(0).getApellidos();
            String mail2 = userRepository.getById(den.getIdDenunciado()).get(0).getCorreo();
            Integer estamentoID = userRepository.getById(den.getIdDenunciado()).get(0).getEstamento();
            String estamento = estamentoRepository.getById(estamentoID).get(0).getNombre();
            Integer estadoID = denuncia.get(i).getIdEstado();
            String estado = estadoRepository.getById(estadoID).get(0).getNombre();
            String date = denuncia.get(i).getFecha();
            String desc = denuncia.get(i).getDescripcion();
            String med = denuncia.get(i).getMedidas();
            VerDenuncia den2 = new VerDenuncia(id,name1,apellidos1,mail1,name2,apellidos2,mail2,estamento,estado,date,desc,med);
            denuncia2.add(den2);
        }
        System.out.println("Se muestran las denucias");
        return denuncia2;
    }
    /*
    D: Funcion que obtiene las denuncias que un usuario tiene en contra
    I: id denuncia (Entero)
    O: Lista Denuncias
    */
    @Override
    public List<VerDenuncia>showDenunciaContra(Integer idDenuncia){
        List <Denuncia> denuncia = findDenunciaDenunciado(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<>();
        for(int i = 0; i < denuncia.size();i++){
            Denuncia den = denuncia.get(i);
            Integer id = denuncia.get(i).getIdDenuncia();
            String name1 = userRepository.getById(den.getIdDenunciante()).get(0).getNombre();
            String apellidos1 = userRepository.getById(den.getIdDenunciante()).get(0).getApellidos();
            String mail1 = userRepository.getById(den.getIdDenunciante()).get(0).getCorreo();
            String name2 = userRepository.getById(den.getIdDenunciado()).get(0).getNombre();
            String apellidos2 = userRepository.getById(den.getIdDenunciado()).get(0).getApellidos();
            String mail2 = userRepository.getById(den.getIdDenunciado()).get(0).getCorreo();
            Integer estamentoID = userRepository.getById(den.getIdDenunciado()).get(0).getEstamento();
            String estamento = estamentoRepository.getById(estamentoID).get(0).getNombre();
            Integer estadoID = denuncia.get(i).getIdEstado();
            String estado = estadoRepository.getById(estadoID).get(0).getNombre();
            String date = denuncia.get(i).getFecha();
            String desc = denuncia.get(i).getDescripcion();
            String med = denuncia.get(i).getMedidas();
            VerDenuncia den2 = new VerDenuncia(id,name1,apellidos1,mail1,name2,apellidos2,mail2,estamento,estado,date,desc,med);
            denuncia2.add(den2);
        }
        System.out.println("Se muestran las denucias");
        return denuncia2;
    }
    /*
    D: Funcion que obtiene las denuncias que un fiscal tiene asignado
    I: id denuncia (Entero)
    O: Lista Denuncias
    */
    @Override
    public List<VerDenuncia>showDenunciaFiscal(Integer idDenuncia){
        List <Denuncia> denuncia = getByFiscal(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<>();
        for(int i = 0; i < denuncia.size();i++){
            Denuncia den = denuncia.get(i);
            Integer id = denuncia.get(i).getIdDenuncia();
            String name1 = userRepository.getById(den.getIdDenunciante()).get(0).getNombre();
            String apellidos1 = userRepository.getById(den.getIdDenunciante()).get(0).getApellidos();
            String mail1 = userRepository.getById(den.getIdDenunciante()).get(0).getCorreo();
            String name2 = userRepository.getById(den.getIdDenunciado()).get(0).getNombre();
            String apellidos2 = userRepository.getById(den.getIdDenunciado()).get(0).getApellidos();
            String mail2 = userRepository.getById(den.getIdDenunciado()).get(0).getCorreo();
            Integer estamentoID = userRepository.getById(den.getIdDenunciado()).get(0).getEstamento();
            String estamento = estamentoRepository.getById(estamentoID).get(0).getNombre();
            Integer estadoID = denuncia.get(i).getIdEstado();
            String estado = estadoRepository.getById(estadoID).get(0).getNombre();
            String date = denuncia.get(i).getFecha();
            String desc = denuncia.get(i).getDescripcion();
            String med = denuncia.get(i).getMedidas();
            VerDenuncia den2 = new VerDenuncia(id,name1,apellidos1,mail1,name2,apellidos2,mail2,estamento,estado,date,desc,med);
            denuncia2.add(den2);
        }
        System.out.println("Se muestran las denucias");
        return denuncia2;
    }
}