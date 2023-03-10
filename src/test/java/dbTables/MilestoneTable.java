package dbTables;

import models.Milestone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;


public class MilestoneTable {
    Logger logger = LogManager.getLogger(MilestoneTable.class);

    private DataBaseService dbService;

    public MilestoneTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Create table milestone");

        String createTableSQL = "" +
                "create table public.milestones " +
                "(id SERIAL PRIMARY KEY," +
                "   name CHARACTER VARYING(30)," +
                "   description CHARACTER VARYING(30)," +
                "   refs CHARACTER VARYING(30)," +
                "   is_completed BOOLEAN" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Delete table milestone");

        String dropTableSQL = "drop table if exists public.milestones;";

        dbService.executeSQL(dropTableSQL);
    }

    public void addMilestone(Milestone milestone) {
        String insertMilestoneTableSQL = "INSERT INTO public.milestones(" +
                "name, description, refs, is_completed)" +
                "VALUES ('" + milestone.getName() + "', '" + milestone.getDescription() +
                "', '" + milestone.getReferences() + "',  '" + milestone.isCompleted() + "');";

        dbService.executeSQL(insertMilestoneTableSQL);
    }

    public ResultSet getMilestoneById(int id) {
        String sql = "SELECT * FROM public.milestones WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void updateMilestone(Milestone milestone) {
        String updateMilestoneSQL = "UPDATE public.milestones SET " +
                "name = '" + milestone.getName() + "', " +
                "description = '" + milestone.getDescription() + "', " +
                "refs = '" + milestone.getReferences() + "', " +
                "is_completed = '" + milestone.isCompleted() + "';";

        dbService.executeSQL(updateMilestoneSQL);
    }

    public void deleteMilestone(int id) {
        String deleteMilestoneSQL = "DELETE FROM public.milestones WHERE id = " + id + ";";

        dbService.executeSQL(deleteMilestoneSQL);
    }
}
