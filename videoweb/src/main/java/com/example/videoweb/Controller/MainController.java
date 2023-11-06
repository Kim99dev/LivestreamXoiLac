package com.example.videoweb.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.videoweb.Model.Match;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    private static List<Match> getMatch(String url) {
        List<Match> results = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements divs = document.select("div[data-hot]");

            for (Element div : divs) {
                if (div.hasAttr("data-hot")) {
                    String dataFid = div.attr("data-fid");
                    String linkchat = "https://api-football.xyz/match/"+dataFid;
                    if (!dataFid.isEmpty()) {
                        String league = div.select("span.text-ellipsis").text();
                        String time = div.select("div.grid-match__date").text();
                        String homeTeam = div.select("span.grid-match__team--home-name").text();
                        String homeLogo = div.select("img.grid-match__team-home-logo").attr("src");
                        String vs = div.select("span.grid-match__vs").text();
                        String awayTeam = div.select("span.grid-match__team--away-name").text();
                        String awayLogo = div.select("img.grid-match__team-away-logo").attr("src");

                        Elements links = div.select("a");

                        for (Element link : links) {
                            String href = link.attr("href");

                            if (!href.equals("https://8xbet70.com") && !href.contains("link=0")) {
                                try {
                                    Document matchPage = Jsoup.connect(href).get();
                                    Elements iframeLinks = matchPage.select("iframe[src~=link|LINK]");

                                    for (Element iframeLink : iframeLinks) {
                                        String linkLivestream = iframeLink.attr("src");
                                        Match match = new Match(dataFid, league, time, homeTeam, homeLogo, vs, awayTeam, awayLogo, href, linkLivestream, linkchat);
                                        results.add(match);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }



    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String listMatches(Model model) {
        List<Match> matches = getMatch("https://xoilacz.com/"); // Thay thế bằng dịch vụ của bạn để lấy danh sách trận đấu
        model.addAttribute("matches", matches);
        return "matchList"; // Đây là tên của template Thymeleaf mà bạn sẽ tạo sau.
    }




}
