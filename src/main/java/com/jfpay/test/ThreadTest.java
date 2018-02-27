package com.jfpay.test;

import com.jfpay.core.domain.to.ReceiveDataTO;
import com.jfpay.core.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ThreadTest extends Thread {
    private static Logger logger = LoggerFactory.getLogger(SocketClient.class);

    int i = 0;

    // 重写run方法，run方法的方法体就是现场执行体
    public void run() {
        while(true) {
            Date start = new Date();
            ReceiveDataTO r = new ReceiveDataTO();
            Map<String, Object> map = new HashMap<>();
            map.put("abc", i);
            map.put("sss", "sdfsadjfksdalkfjkasdljfklsdjfhsdjafklsdfjksdlafkjasdklfjlksdjflkasdjklfjsadkjfklsadjfkljasdlkjfklsdajflkjasdklfjklasdjf" +
                    "jfklsdjfklsdjfkljsdklfjskldjfjksdahgklasdjflkdsklfjksdljflasdjlfkjsdaljfsdlkfjlksdhgklsdajfasdf" +
                    "dlfkjsdklhfgklsdhgkljsadklfjsdlkjhflksadjflksadghjklsdaghklasdjfjkhasdjfkgashfksdajflkasdjlghasdhghjas" +
                    "fsdjlkfhsdhjgjksdhalkfjdsjkghfasdlkjfdasihgkjasdjfjkdshfsdjkfsdhglkasdg" +
                    "sldkfhksdjhglsdjkfujeiojfklasjxnvildkvhklsjdfgnsagbsdkljhgklegujgndklvjsdiogjeklghsdalkjfasd" +
                    "gjhkdlshgbsdkghfjeiojgkldjklvhdjkvbkldsjl;asdklfjpioewujklwafndskjavkljsdjhklgjsdakljgfklsdjfopewjfklwjflkasdf" +
                    "jsdlkvgbhdsfbnvjkfdhieosfujioewjfklasdjfkldsanvjkdsjvlkdasjflkdsjaklfvndklsfjsdalkjfopeijfkasdjf" +
                    "asdfgnkdlsjgkldsnvjfkdbvnjfkvjkfdnvuidfjklsdajfklejoifwnklenfsedjfklsdajl;ahsdgvkldnvdskjjacioef" +
                    "afjkldsgjklsdjgkldsjfiohdskjlgfksdlfjdskvckfdnvjflkjflkasdjfoiwqajq;fkl;sajdfioenlkahfjdsnmvkjhdklsjfioaejnl;afjsdpofwajeklfjasoijfeaw" +
                    "dsjklghdasjknfgsdjkldsajfkldsnklvgjsdlakfjasdljfiopwejlfkajsdklfjioejlak;jsdiofdjslkjflkasjdfoiweajlk;fjals;d" +
                    "fsdjflsadjgoiasdjfeaoifaljjdlifjeaklsjfoidsjaklf;asdjklfjasdl;ujfgseaklghsdklanfasdjflkasdjfoiawe" +
                    "dsalkjfgdlskaghdksjanfkjdsfklsdjafioaejlkfjdskljfkleasjfioaesjklsdjfklasdhnfkldsjakfljdsaklfnlejafklsjdfkl;asd" +
                    "jklsdajgdsiafujklejfaiosdjklfjsdklajfailsdjfeionaklndjkvcxhjvbnmcxvbmcxzbvnmzklfjsdajfiowqeklqjflkqjwekfjdasiofjweklfa" +
                    "sdfjklsdgjiodsafjkleajflkasdjfnsdavdfsjkjkdfjownfdsjkvnisdjfoidsuifowejfndsjkfbdnmsfbewkjaksjfhklejasbnfdsjkbfejklafjioejklsnfjkdajfkldsjfenaljkfdsa" +
                    "jskdlgjasdklfnekjlhfakljdskfndsjkvbdfsjklsdjfienflkasjdvndiosvjeklrfasnkejnfdsasdafkdasfljasd" +
                    "gjkadsjflkasdjfiopejaklfndsjkvhkldsjfvasdofjvklsdajvas" +
                    "fvjklasdjvkldasjvklsdajvklasdjviosdavjklasdjhvioasdjvkldasuvioadsjvklbhdjkzxcbvjhruisyvherwkljhvklsajvlasdkjfgas" +
                    "vdjiocvdsaklvjdklsajvdfkasdjfkljdsaklgjiodfsgvm,nfdjbvklcxjkbvjlkxcj" +
                    "asgfjikosdgubfsdkljgkldasjfioasdjfklwejkfbasdkjgklsdfjbviofudvbkljsdfaas" +
                    "fweklgfkasebgfbasdmnfhbhjkweahfasebfnmbasdm,fbmwehfklajseguidojvklcxjvioxzcuvlkjzxciovuxciolzjvlzxcv" +
                    "ewjfklwesfbjksdbfgjdbgjmdns,mfndask,jfnkl;dasjviosdfjvlkxdjcvilkujcxiovjkledrhvgbjkerbjkhfgdaslkjfasd" +
                    "gvjiodsfuvgcxkljviopcxuvklzxcjiovjcxkl;zujvio;lzxcujviopzcxujvkl;zxcuviojerlkhfgkasdjjflk;asdjiolvucx" +
                    "sdjklgufvidovjilc;xuvlxckjvioprejvkldsfajviopasdujflksduaiojsdvkljxcioxcjviopzxcuvolcxzjvlk;jxczv");
            r.setHead("testMethodrhdf");
            r.setParams(map);
            String s = JsonUtil.toJson(r);
            logger.info(s);
            SocketClient.sendSocketMsg("192.168.1.104", 8000, s.getBytes());
            i++;
            Date end = new Date();
            int seconds = SocketClient.getSeconds(start, end);
            logger.info("-------耗时{}s", seconds);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m() {
        for (int i = 0; i < 15; i++) {//这里循环的是线程数
            logger.info(Thread.currentThread().getName()
                    + "**********************************: " + i);
            new ThreadTest().start();
            // new ThreadTest().start();
        }
    }

}
