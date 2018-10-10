package com.ibrahimyousre.resumebuilder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.ibrahimyousre.resumebuilder.R;
import com.ibrahimyousre.resumebuilder.datamodel.Experience;
import com.ibrahimyousre.resumebuilder.datamodel.PersonalInfo;
import com.ibrahimyousre.resumebuilder.datamodel.Project;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.datamodel.School;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviewFragment extends ResumeFragment {
    WebView webView;

    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new PreviewFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        webView = view.findViewById(R.id.webView);
        StringBuilder htmlContent = new StringBuilder();
        Resume resume = getResume();
        PersonalInfo personalInfo = resume.personalInfo;
        htmlContent.append(String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Resume</title>\n" +
                "<meta charset=UTF-8>\n" +
                "<link rel=\"shortcut icon\" href=https://ssl.gstatic.com/docs/documents/images/kix-favicon6.ico>\n" +
                "<style type=text/css>body{font-family:arial,sans,sans-serif;margin:0}iframe{border:0;frameborder:0;height:100%%;width:100%%}#header,#footer{background:#f0f0f0;padding:10px 10px}#header{border-bottom:1px #ccc solid}#footer{border-top:1px #ccc solid;border-bottom:1px #ccc solid;font-size:13}#contents{margin:6px}.dash{padding:0 6px}</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=contents>\n" +
                "<style type=text/css>@import url('https://themes.googleusercontent.com/fonts/css?kit=xTOoZr6X-i3kNg7pYrzMsnEzyYBuwf3lO_Sc3Mw9RUVbV0WvE1cEyAoIq5yYZlSc');ol{margin:0;padding:0}table td,table th{padding:0}.c26{border-right-style:solid;padding:3.6pt 3.6pt 3.6pt 3.6pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:176.3pt;border-top-color:#fff;border-bottom-style:solid}.c4{border-right-style:solid;padding:5pt 5pt 5pt 5pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:327.7pt;border-top-color:#fff;border-bottom-style:solid}.c16{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Raleway\";font-style:normal}.c7{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c13{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c1{color:#666;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:9pt;font-family:\"Lato\";font-style:normal}.c19{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:6pt;font-family:\"Lato\";font-style:normal}.c20{color:#f2511b;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:16pt;font-family:\"Raleway\";font-style:normal}.c6{padding-top:0;padding-bottom:0;line-height:1.0;text-align:left}.c32{padding-top:5pt;padding-bottom:0;line-height:1.15;text-align:left}.c0{padding-top:10pt;padding-bottom:0;line-height:1.0;text-align:left}.c22{padding-top:5pt;padding-bottom:0;line-height:1.0;text-align:left}.c10{color:#d44500;text-decoration:none;vertical-align:baseline;font-style:normal}.c2{padding-top:0;padding-bottom:0;line-height:1.15;text-align:left}.c33{padding-top:3pt;padding-bottom:0;line-height:1.0;text-align:left}.c9{padding-top:4pt;padding-bottom:0;line-height:1.15;text-align:left}.c23{border-spacing:0;border-collapse:collapse;margin:0 auto}.c30{color:#000;text-decoration:none;vertical-align:baseline;font-style:normal}.c3{padding-top:6pt;padding-bottom:0;line-height:1.15;text-align:left}.c14{padding-top:16pt;padding-bottom:0;line-height:1.15;text-align:left}.c28{padding-top:6pt;padding-bottom:0;line-height:1.0;text-align:left}.c18{font-size:9pt;font-family:\"Lato\";font-weight:400}.c24{font-size:14pt;font-family:\"Lato\";font-weight:700}.c8{font-size:10pt;font-family:\"Lato\";font-weight:400}.c5{font-size:11pt;font-family:\"Lato\";font-weight:400}.c31{background-color:#fff;max-width:504pt;padding:36pt 54pt 36pt 54pt}.c35{font-weight:700;font-size:24pt;font-family:\"Raleway\"}.c11{orphans:2;widows:2;height:11pt}.c21{height:auto}.c15{height:auto}.c27{height:auto}.c34{height:auto}.c29{height:auto}.c25{font-size:10pt}.c12{page-break-after:avoid}.c17{height:265pt}.title{padding-top:6pt;color:#000;font-weight:700;font-size:24pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}.subtitle{padding-top:3pt;color:#f2511b;font-weight:700;font-size:16pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}li{color:#000;font-size:11pt;font-family:\"Lato\"}p{margin:0;color:#000;font-size:11pt;font-family:\"Lato\"}h1{padding-top:4pt;color:#000;font-weight:700;font-size:12pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h2{padding-top:6pt;color:#000;font-weight:700;font-size:11pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h3{padding-top:6pt;color:#666;font-size:9pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h4{padding-top:8pt;-webkit-text-decoration-skip:none;color:#666;text-decoration:underline;font-size:11pt;padding-bottom:0;line-height:1.15;page-break-after:avoid;text-decoration-skip-ink:none;font-family:\"Trebuchet MS\";orphans:2;widows:2;text-align:left}h5{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}</style>\n" +
                "<p class=\"c2 c29\"><span class=c19></span></p>\n" +
                "<a id=t.b7144d62fc47a2bfcf177a3c3dd72df0e868051e></a>\n" +
                "<a id=t.0></a>\n" +
                "<table class=c23>\n" +
                "            <tbody>\n" +
                "                <tr class=\"c21\">\n" +
                "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                "                        <p class=\"c6 c12 title\" id=\"h.4prkjmzco10w\"><span>%s</span></p>\n" +
                "                        <p class=\"c33 subtitle\" id=\"h.o2iwx3vdck7p\"><span class=\"c20\">%s</span></p>\n" +
                "                    </td>\n" +
                "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                "                        <p class=\"c6\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh4.googleusercontent.com/j7t3_XjsJ1PHIrgcWuJOWmQ2fFs9q-TT_LNTDfAXGnVu49aapNgutWcfK1k7pPzGtsu9lOvPynvLW07b_KwpVV0ituspJAXOQ_IBZyN087cqGsXawUahO2qDRCQZ8-qq4esAcP7M\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                "                        <h1 class=\"c3\" id=\"h.lf5wiiqsu4ub\"><span>%s</span></h1>\n" +
                "                        <p class=\"c6\"><span class=\"c7\">%s</span></p>\n" +
                "                        <p class=\"c6\"><span class=\"c25\">%s</span></p>\n" +
                "                        <p class=\"c0\"><span class=\"c10 c8\">%s</span></p>\n" +
                "                        <p class=\"c6\"><span class=\"c8 c10\">%s</span></p>\n" +
                "                    </td>\n" +
                "                </tr>", personalInfo.getName(), personalInfo.getJobTitle(), personalInfo.getName(), personalInfo.getAddressLine1(), personalInfo.getAddressLine2(), personalInfo.getPhone(), personalInfo.getEmail()));

        if (!resume.skills.isEmpty()) {
            htmlContent.append(String.format("\n" +
                    "                <tr class=\"c27\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                    "                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">"+getString(R.string.hint_skills)+"</span></h1></td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                    "                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n" +
                    "                    </td>\n" +
                    "                </tr>", resume.skills));
        }
        if (!resume.languages.isEmpty()) {
            htmlContent.append(String.format("\n" +
                    "                <tr class=\"c27\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                    "                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">"+getString(R.string.hint_languages)+"</span></h1></td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                    "                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n" +
                    "                    </td>\n" +
                    "                </tr>", resume.languages));
        }
        if (resume.schools.size() != 0) {
            htmlContent.append("\n" +
                    "                <tr class=\"c15\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                    "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">"+getString(R.string.education)+"</span></h1></td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
            boolean first = true;
            for (School school : resume.schools) {
                htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                        "                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n" +
                        "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", school.getSchoolName(), school.getDegree(), school.getLocation(), school.getDescription()));
                first = false;
            }
            htmlContent.append("</td>\n" +
                    "                </tr>");
        }
        if (resume.projects.size() != 0) {
            htmlContent.append("\n" +
                    "                <tr class=\"c15\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                    "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">"+getString(R.string.hint_project_name)+"</span></h1></td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
            boolean first = true;
            for (Project project : resume.projects) {
                htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                        "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", project.getName(), project.getDetail(), project.getDescription()));
                first = false;
            }
            htmlContent.append("</td>\n" +
                    "                </tr>");
        }
        if (resume.experience.size() != 0) {
            htmlContent.append("\n" +
                    "                <tr class=\"c15\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                    "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">"+getString(R.string.navigation_experience)+"</span></h1></td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
            boolean first = true;
            for (Experience experience : resume.experience) {
                htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                        "                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n" +
                        "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", experience.getCompany(), experience.getLocation(), experience.getJobTitle(), experience.getDescription()));
                first = false;
            }
            htmlContent.append("</td>\n" +
                    "                </tr>");
        }
        htmlContent.append("</tbody>\n" +
                "</table>\n" +
                "<p class=\"c2 c11\"><span class=\"c30 c5\"></span></p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        webView.loadDataWithBaseURL(null, htmlContent.toString(), "text/html", "utf-8", null);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.print, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_print) {
            createWebPrintJob(webView);
        }
        return super.onOptionsItemSelected(item);
    }

    private void createWebPrintJob(WebView webView) {

        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) getActivity()
                .getSystemService(Context.PRINT_SERVICE);

        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        // Create a print job with name and adapter instance
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());
    }
}
