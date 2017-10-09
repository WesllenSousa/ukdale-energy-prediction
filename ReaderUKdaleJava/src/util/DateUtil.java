/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brandell
 */
public class DateUtil {

    public static Date parseDateUTC(String date) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return isoFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static Date parseDateDDmmYYYYhhMMss(String date) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            return isoFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Calendar adicionaDias(Calendar data, Integer dias) {
        Date d = data.getTime();
        d.setTime(d.getTime() + dias * 1000 * 60 * 60 * 24);
        data.setTime(d);
        return data;
    }

    public static Date adicionaSegundos(Date data, Integer segundos) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(data);
        calendar.add(Calendar.SECOND, segundos); 
        return calendar.getTime(); 
    }

    public static Date adicionaMinutos(Date data, Integer minutos) {
        data.setTime(data.getTime() + minutos * 1000 * 60);
        return data;
    }

    public static Date adicionaHoras(Date data, Integer horas) {
        data.setTime(data.getTime() + horas * 1000 * 60 * 60);
        return data;
    }

    public static Date adicionaDias(Date data, Integer dias) {
        data.setTime(data.getTime() + dias * 1000 * 60 * 60 * 24);
        return data;
    }

    public static Date diminuirDias(Date data, Integer dias) {
        Calendar calendarData = Calendar.getInstance();
        calendarData.setTime(data);
        int numeroDiasParaSubtrair = dias * -1;
        calendarData.add(Calendar.DATE, numeroDiasParaSubtrair);
        return calendarData.getTime();
    }

    public static Calendar dateParaCalendar(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal;
    }

    public static Float milisegundoParaSegundo(Long inicio, Long fim) {
        return (fim - inicio) / 1000f;
    }

    public static Integer milisegundoParaMinuto(Long inicio, Long fim) {
        Float segundo = (fim - inicio) / 1000f;
        return (int) (segundo % 3600) / (int) 60;
    }

    public static int quantidadeDiasEntreDuasDatas(Date inicial, Date finall) {
        int diffDays = (int) ((inicial.getTime() - finall.getTime()) / (24 * 60 * 60 * 1000));  // 7
        return diffDays;
    }

    public static String quantidadeHoraMinutoSegundoEntreDuasDatas(Calendar inicial, Calendar finall) {
        int difMili = (int) ((finall.getTimeInMillis() - inicial.getTimeInMillis()) / 1000);
        int diffHor = (int) difMili / (int) 3600;
        int diffMin = (int) (difMili % 3600) / (int) 60;
        int diffSeg = (difMili % 3600) % 60;
        return diffHor + ":" + diffMin + ":" + diffSeg;
    }

    public static String getDataDia() {
        Date date = new Date();
        DateFormat formatData = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return formatData.format(date);
    }

    public static String getHoraDia() {
        Date date = new Date();
        DateFormat formatData = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        return formatData.format(date);
    }

    public static Boolean verificarDataMaiorDataAtual(Calendar data) {
        Date date = new Date();
        Calendar hoje = Calendar.getInstance();
        hoje.setTime(date);
        long dataHoje = hoje.getTimeInMillis();
        long dataTeste = data.getTimeInMillis();
        if (dataTeste > dataHoje) {
            return true;
        }
        return false;
    }

    public static Boolean verificarDataMaior(Calendar data1, Calendar data2) {
        long _data1 = data1.getTimeInMillis();
        long _data2 = data2.getTimeInMillis();
        if (_data1 > _data2) {
            return true;
        }
        return false;
    }

    public static Boolean verificarDataMaior(Date data1, Date data2) {
        long _data1 = data1.getTime();
        long _data2 = data2.getTime();
        if (_data1 > _data2) {
            return true;
        }
        return false;
    }

    public static Calendar preparaDataInicio(Calendar data) {
        if (data != null) {
            data.set(Calendar.HOUR_OF_DAY, 00);
            data.set(Calendar.MINUTE, 00);
            data.set(Calendar.SECOND, 00);
            return data;
        }
        return null;
    }

    public static Calendar preparaDataFinal(Calendar data) {
        if (data != null) {
            data.set(Calendar.HOUR_OF_DAY, 23);
            data.set(Calendar.MINUTE, 59);
            data.set(Calendar.SECOND, 59);
            return data;
        }
        return null;
    }

    public static Calendar setaHoraCalendar(Calendar data, Integer h, Integer m, Integer s) {
        if (data != null) {
            data.set(Calendar.HOUR_OF_DAY, h);
            data.set(Calendar.MINUTE, m);
            data.set(Calendar.SECOND, s);
            return data;
        }
        return null;
    }

    /*
     Formatos
     */
    public static String getFormattedData(Calendar data) {
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        String retorno = sp.format(data.getTime()) + " at ";
        sp.applyPattern("hh : mm");
        return retorno + sp.format(data.getTime());
    }

    public static String formataMes(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("MM");
        return dataFormat.format(data.getTime());
    }

    public static String formataMesAno(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("MM/yyyy");
        return dataFormat.format(data.getTime());
    }

    public static String formataDia(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd");
        return dataFormat.format(data.getTime());
    }

    public static String formataAno(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
        return dataFormat.format(data.getTime());
    }

    public static String formataDiaMes(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM");
        return dataFormat.format(data.getTime());
    }

    public static String formataHora(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH");
        return dataFormat.format(data.getTime());
    }

    public static String formataMes(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("MM");
        return dataFormat.format(data);
    }

    public static String formataMesAno(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("MM/yyyy");
        return dataFormat.format(data);
    }

    public static String formataDia(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd");
        return dataFormat.format(data);
    }

    public static String formataAno(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy");
        return dataFormat.format(data);
    }

    public static String formataDiaMes(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM");
        return dataFormat.format(data);
    }

    public static String formataHora(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH");
        return dataFormat.format(data);
    }

    public static Date formataData(String data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dataFormat.parse(data);
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date formataDataHora(String data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        try {
            return dataFormat.parse(data);
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Calendar formataDataCalendar(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(data));
            return cal;
        } catch (ParseException e) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public static Date formataHora(String data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH");
        try {
            return dataFormat.parse(data);
        } catch (ParseException ex) {
        }
        return null;
    }

    public static String formataData(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dataFormat.format(data);
    }

    public static String formataDataYyyyMMdd(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dataFormat.format(data);
    }

    public static String formataDataYyyyMMddHHmmSS(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dataFormat.format(data);
    }

    public static String formataDataHHmmSSMMddYYYY(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
        return dataFormat.format(data);
    }

    public static String formataHoraMinuto(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm");
        return dataFormat.format(data);
    }

    public static String formataData(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dataFormat.format(data.getTime());
    }

    public static String formataDataHora(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        return (dataFormat.format(data.getTime()));
    }

    public static String formataDataHHmmSS(Calendar data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        return (dataFormat.format(data.getTime()));
    }

    public static String formataDataHora(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        return (dataFormat.format(data));
    }

    public static String formataDataddMMHHmm(Date data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM HH:mm");
        return (dataFormat.format(data));
    }

}
