package com.ood.waterball.teampathy.Fragments;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ood.waterball.teampathy.Fragments.Architecture.TemplateFragment;
import com.ood.waterball.teampathy.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ChartWebViewFragment extends TemplateFragment {

    private static final String XML_PARAM = "xml parameter";
    private static final String XSLFILENAME_PARAM = "xsl parameter";

    private WebView webview;
    private ProgressBar progressBar;

    enum XslType {
        WBS,GanttChart;

        public String toFileName() {
            return name() + ".xsl";
        }
    }

    private String xml;
    private String webContent;

    public ChartWebViewFragment() {
        // Required empty public constructor
    }

    public static ChartWebViewFragment newInstance(String xml, XslType xslXslType) {
        ChartWebViewFragment fragment = new ChartWebViewFragment();
        Bundle args = new Bundle();
        args.putString(XML_PARAM, xml);
        args.putString(XSLFILENAME_PARAM, xslXslType.toFileName());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chart_webview;
    }

    @Override
    protected void onFetchData(@Nullable Bundle arguBundle) {
        try {
            xml = arguBundle.getString(XML_PARAM);
            InputStream is = openXslStream(arguBundle.getString(XSLFILENAME_PARAM));
            webContent = getXmlTransformWithXsl(xml,is);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private InputStream openXslStream(String xslFileName) throws IOException {
        AssetManager assetManager = getContext().getAssets();
        return assetManager.open(xslFileName);
    }

    private String getXmlTransformWithXsl(String xml, InputStream xslIs) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(xslIs);
        Transformer transformer = factory.newTransformer(xslt);
        StringWriter resultWriter = new StringWriter();
        transformer.transform(new StreamSource(xml), new StreamResult(resultWriter));
        return resultWriter.toString();
    }

    @Override
    protected void onFindViews(View parentView) {
        progressBar = (ProgressBar) parentView.findViewById(R.id.progressBar);
        webview = (WebView) parentView.findViewById(R.id.webview);
    }

    @Override
    protected void onControlViews() {
        webview.loadData(webContent,"text/xml; charset=utf-8", "utf-8");
        progressBar.setVisibility(View.GONE);
        webview.setVisibility(View.VISIBLE);
    }
}
