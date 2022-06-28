package com.example.fingeso.repositories;
import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.Estamento;
import com.example.fingeso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class EstamentoRepositoryImp implements EstamentoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstamentos() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM estamento").executeScalar(Integer.class);
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
    public List<Estamento> getAllEstamentos() {
        final String query = "select * from estamento";
        final List<Estamento> estamentoTotal;
        Connection conn = sql2o.open();
        try( conn ){
            estamentoTotal = conn.createQuery(query).executeAndFetch(Estamento.class);
            return estamentoTotal ;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    public List<Estamento> getById(Integer id){
        final String query = "SELECT * FROM estamento WHERE id_estamento = '" + id + "'";
        final List<Estamento> usersRol;
        Connection conn = sql2o.open();
        try( conn ){
            usersRol = conn.createQuery(query).executeAndFetch(Estamento.class);
            return usersRol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
    public Integer postEstamento(@RequestBody Estamento estamento){
        Connection con = sql2o.open();
        final String query  =
                "insert into estamento (id_estamento,nombre)"+
                        "VALUES (:id_estamento, :nombre)";
        int total = countEstamentos();
        try ( con ) {
            con.createQuery(query)
                    .addParameter("id_estamento", total)
                    .addParameter("nombre", estamento.getNombre())
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
}
