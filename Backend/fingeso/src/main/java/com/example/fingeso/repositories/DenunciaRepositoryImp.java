package com.example.fingeso.repositories;
import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.IngresarDenuncia;
import com.example.fingeso.models.VerDenuncia;
import com.example.fingeso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
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
     * -1: error
     * 0: exitoso
     */
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
    -1 representa ID de estado erroneo
    0 implica que hubo un error
    1 representa una actualizacion exitosa
     */
    @Override
    public Integer updateDenuncia(Integer id_denuncia, String id_estadoo){
        Integer id_estado = Integer.parseInt(id_estadoo);
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
            System.out.println("Success");
            return 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }
    public List<VerDenuncia> showDenuncia(Integer idDenucia){
        List <Denuncia >den = getById(idDenucia);
        List <VerDenuncia> denuncia2 = new ArrayList<VerDenuncia>();
        String name1 = userRepository.getById(den.get(0).getIdDenunciante()).get(0).getNombre();
        String apellidos1 = userRepository.getById(den.get(0).getIdDenunciante()).get(0).getApellidos();
        String mail1 = userRepository.getById(den.get(0).getIdDenunciante()).get(0).getCorreo();
        String name2 = userRepository.getById(den.get(0).getIdDenunciado()).get(0).getNombre();
        String apellidos2 = userRepository.getById(den.get(0).getIdDenunciado()).get(0).getApellidos();
        String mail2 = userRepository.getById(den.get(0).getIdDenunciado()).get(0).getCorreo();
        Integer estamentoID = userRepository.getById(den.get(0).getIdDenunciante()).get(0).getEstamento();
        String estamento = estamentoRepository.getById(estamentoID).get(0).getNombre();
        Integer estadoID = den.get(0).getIdEstado();
        String estado = estadoRepository.getById(estadoID).get(0).getNombre();
        String date = den.get(0).getFecha();
        String desc = den.get(0).getDescripcion();
        String med = den.get(0).getMedidas();
        VerDenuncia denu2 = new VerDenuncia(idDenucia,name1,apellidos1,mail1,name2,apellidos2,mail2,estamento,estado,date,desc,med);
        denuncia2.add(denu2);
        return denuncia2;
    }
    public List<VerDenuncia>showDenunciaRealizada(Integer idDenuncia){
        List <Denuncia> denuncia = findDenunciaDenunciante(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<VerDenuncia>();
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
    public List<VerDenuncia>showDenunciaContra(Integer idDenuncia){
        List <Denuncia> denuncia = findDenunciaDenunciado(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<VerDenuncia>();
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
    public List<VerDenuncia>showDenunciaFiscal(Integer idDenuncia){
        List <Denuncia> denuncia = getByFiscal(idDenuncia);
        if(denuncia.isEmpty()){
            System.out.println("No fue posible mostrar las denuncias");
            return null;
        }
        List <VerDenuncia> denuncia2 = new ArrayList<VerDenuncia>();
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