package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel < ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {
    private final Connection connection;

    protected BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }

    public void save (TYPE entity) {
       String sql = "INSERT INTO "+ getTableName()+ " " +getColumnName()+ " VALUES "+getCountOfQMarks();
       try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           fillPAramForPS(preparedStatement,entity, false);
           preparedStatement.executeUpdate();
       }
       catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }
    public TYPE findById (ID id){
        return null;
    }

    public abstract String getTableName();
    public abstract String getColumnName();
    public abstract String getCountOfQMarks();
    public abstract String fillPAramForPS(PreparedStatement preparedStatement,TYPE entity, Boolean isCountOnly );

}
