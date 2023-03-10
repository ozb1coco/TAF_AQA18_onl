package dbTables;

import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class ProjectTable {

    Logger logger = LogManager.getLogger(ProjectTable.class);

    private DataBaseService dbService;

    public ProjectTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Create project table");

        String createTableSQL = "" +
                "create table public.projects " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    announcement CHARACTER VARYING(30)," +
                "    suite_mode INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Delete project table");

        String dropTableSQL = "drop table if exists public.projects;";

        dbService.executeSQL(dropTableSQL);
    }

    public void addProject(Project project) {
        String insertTableSQL = "INSERT INTO public.projects(" +
                "name, announcement, suite_mode)" +
                "VALUES ('" + project.getName() + "', '" + project.getAnnouncement() +
                "',  " + project.getType() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void deleteProjectById(int id) {
        String deleteProjectSQL = "DELETE FROM public.projects WHERE id = " + id + ";";

        dbService.executeSQL(deleteProjectSQL);
    }
}
