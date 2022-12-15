package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());
    
    private Connection cn;
    
    public SqlTracker() {
        init();
    }
    
    public SqlTracker(Connection cn) {
        this.cn = cn;
    }
    
    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            LOG.error("Exception in SQLTracker", e);
        }
    }
    
    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }
    
    /*методы execute(), executeUpdate() и executeQuery() интерфейса PreparedStatement
    не принимают никаких аргументов, в отличие от одноименных методов Statement.
    Они выполняют указанный при создании объекта (PreparedStatement) SQL-запрос с подставленными аргументами*/
    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items (name, created) VALUES (?,?);",
                Statement.RETURN_GENERATED_KEYS)) {
            /* Из Timestamp в LocalDateTime */
            /*long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            LocalDateTime localDateTime = timestamp.toLocalDateTime();*/
            /* Из LocalDateTime в Timestamp */
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            ps.setString(1, item.getName());
            ps.setTimestamp(2, timestampFromLDT);
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return item;
    }
    
    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?;")) {
            ps.setString(1, item.getName());
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            ps.setTimestamp(2, timestampFromLDT);
            ps.setInt(3, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return result;
    }
    
    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id = ?;")) {
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return result;
    }
    
    private Item createItem(ResultSet resultSet) {
        Item item = null;
        try {
            item = new Item(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getTimestamp("created").toLocalDateTime()
            );
        } catch (SQLException e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return item;
    }
    
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("SELECT * FROM items;")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(createItem(resultSet));
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return items;
    }
    
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("SELECT * FROM items WHERE name = ?;")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(createItem(resultSet));
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return items;
    }
    
    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement("SELECT * FROM items WHERE id = ?;")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = createItem(resultSet);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in SQLTracker", e);
        }
        return item;
    }
}
