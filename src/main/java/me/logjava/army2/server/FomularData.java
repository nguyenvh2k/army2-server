/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.logjava.army2.server;

import java.util.ArrayList;

/**
 *
 * @author ASD
 */
public class FomularData {

    public static class FomularDataEntry {

        SpecialItemData.SpecialItemEntry ins;
        byte equipType;
        NVData.EquipmentEntry[] equip;
        NVData.EquipmentEntry[] equipNeed;
        ArrayList<FomularEntry> entrys;
    }

    public static class FomularEntry {

        byte level;
        int levelRequire;
        short[] invAddMin;
        short[] invAddMax;
        short[] percenAddMin;
        short[] percenAddMax;
        SpecialItemData.SpecialItemEntry[] itemNeed;
        short[] itemNeedNum;
        String[] detail;
    }

    public static ArrayList<FomularDataEntry> entrys;

    public static void addFomularEntry(int materialId, byte equipType, short[] eqId, short[] eqNeedId, FomularEntry fEntry) {
        System.out.println("Set fomular materialId=" + materialId + " equipType=" + equipType);
        FomularDataEntry fDatEntry = null;
        for (FomularDataEntry fDatEntry2 : entrys) {
            if (fDatEntry2.ins.id == materialId) {
                fDatEntry = fDatEntry2;
                break;
            }
        }
        // Neu ko ton tai -> tao moi
        if (fDatEntry == null) {
            fDatEntry = new FomularDataEntry();
            fDatEntry.ins = SpecialItemData.getSpecialItemById(materialId);
            fDatEntry.equipType = equipType;
            fDatEntry.equip = new NVData.EquipmentEntry[eqId.length];
            fDatEntry.equipNeed = new NVData.EquipmentEntry[eqNeedId.length];
            for (int i = 0; i < eqId.length; i++) {
                fDatEntry.equip[i] = NVData.getEquipEntryById(i, equipType, eqId[i]);
                fDatEntry.equipNeed[i] = NVData.getEquipEntryById(i, equipType, eqNeedId[i]);
            }
            fDatEntry.entrys = new ArrayList<>();
            entrys.add(fDatEntry);
        }
        // Them fomular entry neu ko ton tai
        for (FomularEntry fE1 : fDatEntry.entrys) {
            // Neu ton tai -> thoat
            if (fE1.level == fEntry.level) {
                return;
            }
        }
        // Neu ko ton tai -> tao moi
        fDatEntry.entrys.add(fEntry);
    }

    public static FomularDataEntry getFomularDataEntryById(int materialId) {
        for (FomularDataEntry fDatEntry : entrys) {
            if (fDatEntry.ins.id == materialId) {
                return fDatEntry;
            }
        }
        return null;
    }

}
