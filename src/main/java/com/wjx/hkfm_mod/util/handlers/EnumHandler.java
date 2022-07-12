package com.wjx.hkfm_mod.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
    public static enum EnumType implements IStringSerializable{

        STONE_FOR_HONKAI(0,"stone_for_honkai"),
        ALUMINIUM(1,"aluminium");


        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name,unlocializedname;

        private EnumType(int meta,String name){
            this(meta,name,name);

        }

        private EnumType(int meta,String name,String unlocializedname){
            this.meta = meta;
            this.name = name;
            this.unlocializedname = unlocializedname;

        }

        @Override
        public String getName(){
            return this.name;
        }

        public int getMeta(){
            return this.meta;
        }

        public String geUnlocializedname(){
            return this.unlocializedname;
        }

        @Override
        public String toString(){
            return this.name;
        }

        public static EnumType byMetaData(int meta){
            return META_LOOKUP[meta];
        }
        static{
            for (EnumType enumType :values()){
                META_LOOKUP[enumType.getMeta()] = enumType;
            }
        }
    }
}
