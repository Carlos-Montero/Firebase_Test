package com.example.carlos.firebase_test.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import java.util.List;

//import com.dynatech2012.myexampleapp.model.list.ListItem;
//import com.dynatech2012.myexampleapp.model.list.ListItemDao;
//import com.dynatech2012.myexampleapp.model.list.ListItemDatabase;
import com.example.carlos.firebase_test.model.Drug;
import com.example.carlos.firebase_test.model.DrugDAO;
import com.example.carlos.firebase_test.model.DrugDatabase;


public class DatabaseDrugRepository {

    private DrugDAO mDrugDAO;

    public DatabaseDrugRepository(Application application) {
        DrugDatabase dbDrug = DrugDatabase.getDatabase(application);
        //ListItemDatabase dbListItem = ListItemDatabase.getDatabase(application);

        //Se llama a drugDAO (DrugDatabase)
        mDrugDAO = dbDrug.drugDAO();
        //mListItemDao = dbListItem.listItemDao();
    }


    /*public void insert(Drug drug) {
        new insertAsyncTask(mDrugDAO).execute(drug);
    }

    //FALTA EL void deleteAllUsers();

    public void deleteDrug(Drug drug) {
        new deleteAsyncTask(mDrugDAO).execute(drug);
    }
*/
    public List<Drug> getAllDrugs() {
        return mDrugDAO.getAllDrugs();
    }

    public LiveData<List<Drug>> getAllDrugsLive(){ return mDrugDAO.getAllDrugsLive(); }

    public List<Drug> getDrugById(String drugId) {
        return mDrugDAO.getDrugById(drugId);
    }

     /*

    ESTO PARA QUE SE UTILIZA??????????*******************************************

    private DrugDAO mAsyncTaskDao;

    deleteAsyncTask(DrugDAO){ mAsyncTaskDao = dao; }

    @Override
    protected Void doInBackground(Drug... drugs) {
        mAsyncTaskDao.deleteDrug(drugs[0]);
        return null;
    }
*/

}
