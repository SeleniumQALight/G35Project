package testDB;

import libs.Database;
import libs.Utils;
import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataBase {
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDataBase.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySql DB connected");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDataBase() throws SQLException, IOException, ClassNotFoundException {
        List<ArrayList> dataFromSeleniumTable
                = dbMySql.selectTable("select* from seleniumTable where login = 'test'");
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info("3 line = " + dataFromSeleniumTable.get(2).get(3));
//        int effectedRows = dbMySql.changeTable(
//                "insert into seleniumTable values(77, 'pasternak', 'tatata')");

        dataFromSeleniumTable
                = dbMySql.selectTable("select* from seleniumTable where login = 'pasternak'");
        logger.info("Result = " + dataFromSeleniumTable);

        UtilsForDB utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("pasternak");
        logger.info(utilsForDB.getPassForLogin("pasternak"));
    }
}
