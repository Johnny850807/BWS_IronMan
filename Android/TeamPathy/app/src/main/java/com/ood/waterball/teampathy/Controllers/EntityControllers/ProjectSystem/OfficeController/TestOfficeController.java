package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.OfficeController;


import android.content.res.AssetManager;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.FileParser;
import com.ood.waterball.teampathy.DomainModels.Domains.User;

import java.io.InputStream;

public class TestOfficeController implements OfficeController {
    private String taskAnalysis = "";


    @Override
    public void modifyPosition(User user, int projectId, Position position) throws Exception {

    }

    @Override
    public void evictMember(User user, int projectId) throws Exception {

    }

    @Override
    public void updateTaskAnalysis(String taskAnalysis, int projectId) throws Exception {

    }

    @Override
    public String getTaskAnalysis(int projectId) throws Exception {
        AssetManager assetManager = Global.resources.getAssets();
        InputStream is = assetManager.open("testwbs.xml");
        return FileParser.readInputStream(is);
    }
}
