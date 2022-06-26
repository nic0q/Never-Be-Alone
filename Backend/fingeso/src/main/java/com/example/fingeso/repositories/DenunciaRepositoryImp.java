package com.example.fingeso.repositories;
import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.User;
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

    //@Override
    public int countDenuncias(){
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM DENUNCIAS").executeScalar(Integer.class);
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
    //@Override
    public List<Denuncia> getAllDenuncias(){
        final String query = "select * from denuncias";
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

    public List<Denuncia> getByFiscal(User fiscalACargo){
        final String query = "select * from denuncias where fiscal =: fiscalACargo";
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

    //@Override
    public List<Denuncia> findDenunciaDenunciante(User user){
        Integer IDuser;
        final String query = "select * from denuncias where denuncianteID =: IDuser";
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

    //@Override
    public List<Denuncia> findDenunciaDenunciado(User user){
        Integer IDuser;
        final String query = "select * from denuncias where denunciadoID =: IDuser";
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
    public Integer insertDenounce(@RequestBody Denuncia denuncia){
        Connection conn = sql2o.open();
        int total = countDenuncias();
        final String query = "insert into denuncias (denuncianteID,estamento,hechos,medidasPrevencion,denunciadoID,estado,fiscalID)"+
                "values (:denuncianteID, :estamento, :hechos, :medidasPrevencion, :denunciadoID, :estado,:fiscalID)";
        try (conn) {
            System.out.println(denuncia.getIdDenunciante());
            conn.createQuery(query)
                    .addParameter("denuncianteID",1)
                    .addParameter("estamento",2)
                    .addParameter("hechos",3)
                    .addParameter("medidasPrevencion",4)
                    .addParameter("denunciadoID",5)
                    .addParameter("estado",6)
                    .addParameter("fiscalID",7)
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
