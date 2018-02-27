package com.jfpay.test;

import com.jfpay.core.domain.to.ReceiveDataTO;
import com.jfpay.core.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SocketClienttest {

    private static Logger logger = LoggerFactory.getLogger(SocketClient.class);

    public SocketClienttest(){

    };
////
//    public SocketClient1(){
//        this.ip=ip;
//        this.port=port;
//    }

    public static void main(String[] args){
        Date start = new Date();
        ReceiveDataTO r=new ReceiveDataTO();
        Map<String,Object> map=new HashMap<>();
        map.put("abc","222");
        map.put("sss","sdfsadjfksdalkfjkasdljfklsdjfhsdjafklsdfjksdlafkjasdklfjlksdjflkasdjklfjsadkjfklsadjfkljasdlkjfklsdajflkjasdklfjklasdjf" +
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
        String s= JsonUtil.toJson(r);
        logger.info(s);
        sendByteMsg(s.getBytes());
    }

    public static String sendSocketMsg(String msg){
        try {
            return sendByteMsg(msg.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    static String sendByteMsg(byte[] bytes){

        Socket socket=null;
        BufferedReader br=null;
        OutputStream out=null;
        InputStream in=null;
        ByteBuffer header=null;
        try{
            socket=new Socket();
            socket.connect(new InetSocketAddress("localhost",Integer.parseInt("8000")));
            //socket.getKeepAlive();
            out=socket.getOutputStream();
            header=ByteBuffer.allocate(4);
            header.putInt(bytes.length);
            out.write(header.array());
            out.write(bytes);
            out.flush();
            in=socket.getInputStream();
            br=new BufferedReader((new InputStreamReader(in,"utf-8")));
            socket.shutdownOutput();
            String reply=null;
            StringBuffer infoS=new StringBuffer("");
            while(!((reply=br.readLine())==null)){
                infoS.append(reply);
            }
//            String returnInfo=infoS.substring(infoS.indexOf("jfpal-")+"jfpal-".length());
            logger.info("接收到的信息:"+infoS);
            if(StringUtils.isBlank(infoS.toString())){
                logger.error("服务器返回报文为空");
                return "";
            }
            return infoS.toString();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("SocketClient.sendSocketMsg [交互异常 Excetion = {}]",
                    new String[] { e.getMessage() }, e);
            return null;
        }catch(Exception e){
            e.printStackTrace();
            logger.error("SocketClient.sendSocketMsg [交互异常 Excetion = {}]",
                    new String[] { e.getMessage() }, e);
            return null;
        }
        finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (Exception e){
            }
            try{
                if(out!=null){
                    out.close();
                }
            }catch (Exception e){
            }
            try{
                if(br!=null){
                    br.close();
                }
            }catch (Exception e){
            }
            try{
                if(socket!=null){
                    socket.close();
                }
            }catch (Exception e){
                logger.error("SocketClient.sendSocketMsg [socket关闭异常, 系统异常 Excetion = {}]",
                        new String[] { e.getMessage() }, e);
            }
        }
    }

}
