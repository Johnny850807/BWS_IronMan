package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import android.content.res.AssetManager;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestOfficeController implements OfficeController {
    private String taskAnalysis = "";


    @Override
    public void modifyPosition(Member member, int projectId, Position position) throws Exception {

    }

    @Override
    public void evictMember(Member member, int projectId) throws Exception {

    }

    @Override
    public void updateTaskAnalysis(String taskAnalysis, int projectId) throws Exception {

    }

    @Override
    public String getTaskAnalysis(int projectId) throws Exception {
        AssetManager assetManager = Global.resources.getAssets();
        InputStream is = assetManager.open("testwbs.xml");
        return readTextFile(is);
    }

    private String readTextFile(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
