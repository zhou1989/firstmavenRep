package com.zdl.hj.javaapitest;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private static Map<String,List<ApiblkeacBalGen>> groupByEacNbr(List<ApiblkeacBalGen> list){
        Map<String,List<ApiblkeacBalGen>> map = list.stream().collect(Collectors.groupingBy(ApiblkeacBalGen::getEacNbr));
        return map;
    }

    private static List<ApiblkeacBalGen> getMaxFscbthnbrApiblkeacBalGen(Map<String,List<ApiblkeacBalGen>>map){
        List<ApiblkeacBalGen> apiblkeacBalGenList = new ArrayList<>();
        map.forEach((k,v)->{
            ApiblkeacBalGen apiblkeacBalGen = v.stream().max(Comparator.naturalOrder()).orElse(null);
            apiblkeacBalGenList.add(apiblkeacBalGen);
        });

        return apiblkeacBalGenList;
    }




    public static void main(String [] args){
        Map<String,List<ApiblkeacBalGen>> map = new HashMap<>();
        List<ApiblkeacBalGen> list1 = new ArrayList<>();
        List<ApiblkeacBalGen> list2 = new ArrayList<>();
        ApiblkeacBalGen apiblkeacBalGen = new ApiblkeacBalGen();
        apiblkeacBalGen.setBalAmt(new BigDecimal(0));
        apiblkeacBalGen.setCcyNbr("12");
        apiblkeacBalGen.setFscbthnbr("0001");
        apiblkeacBalGen.setEacNbr("01");
        ApiblkeacBalGen apiblkeacBalGen2 = new ApiblkeacBalGen();
        apiblkeacBalGen2.setBalAmt(new BigDecimal(0));
        apiblkeacBalGen2.setCcyNbr("12");
        apiblkeacBalGen2.setFscbthnbr("0007");
        apiblkeacBalGen2.setEacNbr("01");
        list1.add(apiblkeacBalGen);
        list1.add(apiblkeacBalGen2);
        map.put("z01",list1);

        ApiblkeacBalGen apiblkeacBalGen3 = new ApiblkeacBalGen();
        apiblkeacBalGen3.setBalAmt(new BigDecimal(0));
        apiblkeacBalGen3.setCcyNbr("12");
        apiblkeacBalGen3.setFscbthnbr("0003");
        apiblkeacBalGen3.setEacNbr("02");
        ApiblkeacBalGen apiblkeacBalGen4 = new ApiblkeacBalGen();
        apiblkeacBalGen4.setBalAmt(new BigDecimal(0));
        apiblkeacBalGen4.setCcyNbr("12");
        apiblkeacBalGen4.setFscbthnbr("0005");
        apiblkeacBalGen4.setEacNbr("02");
        list2.add(apiblkeacBalGen3);
        list2.add(apiblkeacBalGen4);
        map.put("z02",list2);

        ApiblkeacBalGen apiblkeacBalGen5 = new ApiblkeacBalGen();
        apiblkeacBalGen.setBalAmt(new BigDecimal(0));
        apiblkeacBalGen.setCcyNbr("00");
        apiblkeacBalGen.setFscbthnbr("0001");
        apiblkeacBalGen.setEacNbr("05");

        List<ApiblkeacBalGen> list = getMaxFscbthnbrApiblkeacBalGen(map);
        list.size();
        for (ApiblkeacBalGen balGen:list){
            System.out.println(balGen);
        }

        List<ApiblkeacBalGen> list3 = Arrays.asList(apiblkeacBalGen,apiblkeacBalGen2,apiblkeacBalGen3,apiblkeacBalGen4,apiblkeacBalGen5);
        Map<String,List<ApiblkeacBalGen>> map1 = groupByEacNbr(list3);


        ClpbusAccnew c = new ClpbusAccnew("05","16",new BigDecimal(80));
        ClpbusAccnew c2= new ClpbusAccnew("05","10",new BigDecimal(16));
        List<ClpbusAccnew> clpbusAccnewList = Arrays.asList(c,c2);
        list3.stream().map(m->{
            clpbusAccnewList.stream().filter(m2->Objects.equals(m.getEacNbr(),m2.getEacNbr())).forEach(m2->{
                m.setBalAmt(m2.getBalAmt());
                m.setCcyNbr(m2.getCcyType());

            });
            return m;
        }).distinct().collect(Collectors.toList());

        String a = " ";

    }

}
