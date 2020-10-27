package com.mizhi.yxd.entity;

import java.util.ArrayList;
import java.util.List;

public class SubPoorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubPoorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andVillageIsNull() {
            addCriterion("village is null");
            return (Criteria) this;
        }

        public Criteria andVillageIsNotNull() {
            addCriterion("village is not null");
            return (Criteria) this;
        }

        public Criteria andVillageEqualTo(String value) {
            addCriterion("village =", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotEqualTo(String value) {
            addCriterion("village <>", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThan(String value) {
            addCriterion("village >", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThanOrEqualTo(String value) {
            addCriterion("village >=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThan(String value) {
            addCriterion("village <", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThanOrEqualTo(String value) {
            addCriterion("village <=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLike(String value) {
            addCriterion("village like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotLike(String value) {
            addCriterion("village not like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageIn(List<String> values) {
            addCriterion("village in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotIn(List<String> values) {
            addCriterion("village not in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageBetween(String value1, String value2) {
            addCriterion("village between", value1, value2, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotBetween(String value1, String value2) {
            addCriterion("village not between", value1, value2, "village");
            return (Criteria) this;
        }

        public Criteria andCunIsNull() {
            addCriterion("cun is null");
            return (Criteria) this;
        }

        public Criteria andCunIsNotNull() {
            addCriterion("cun is not null");
            return (Criteria) this;
        }

        public Criteria andCunEqualTo(String value) {
            addCriterion("cun =", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunNotEqualTo(String value) {
            addCriterion("cun <>", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunGreaterThan(String value) {
            addCriterion("cun >", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunGreaterThanOrEqualTo(String value) {
            addCriterion("cun >=", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunLessThan(String value) {
            addCriterion("cun <", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunLessThanOrEqualTo(String value) {
            addCriterion("cun <=", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunLike(String value) {
            addCriterion("cun like", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunNotLike(String value) {
            addCriterion("cun not like", value, "cun");
            return (Criteria) this;
        }

        public Criteria andCunIn(List<String> values) {
            addCriterion("cun in", values, "cun");
            return (Criteria) this;
        }

        public Criteria andCunNotIn(List<String> values) {
            addCriterion("cun not in", values, "cun");
            return (Criteria) this;
        }

        public Criteria andCunBetween(String value1, String value2) {
            addCriterion("cun between", value1, value2, "cun");
            return (Criteria) this;
        }

        public Criteria andCunNotBetween(String value1, String value2) {
            addCriterion("cun not between", value1, value2, "cun");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andSixFifteenIsNull() {
            addCriterion("six_fifteen is null");
            return (Criteria) this;
        }

        public Criteria andSixFifteenIsNotNull() {
            addCriterion("six_fifteen is not null");
            return (Criteria) this;
        }

        public Criteria andSixFifteenEqualTo(Integer value) {
            addCriterion("six_fifteen =", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenNotEqualTo(Integer value) {
            addCriterion("six_fifteen <>", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenGreaterThan(Integer value) {
            addCriterion("six_fifteen >", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenGreaterThanOrEqualTo(Integer value) {
            addCriterion("six_fifteen >=", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenLessThan(Integer value) {
            addCriterion("six_fifteen <", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenLessThanOrEqualTo(Integer value) {
            addCriterion("six_fifteen <=", value, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenIn(List<Integer> values) {
            addCriterion("six_fifteen in", values, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenNotIn(List<Integer> values) {
            addCriterion("six_fifteen not in", values, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenBetween(Integer value1, Integer value2) {
            addCriterion("six_fifteen between", value1, value2, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andSixFifteenNotBetween(Integer value1, Integer value2) {
            addCriterion("six_fifteen not between", value1, value2, "sixFifteen");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumIsNull() {
            addCriterion("head_of_house_num is null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumIsNotNull() {
            addCriterion("head_of_house_num is not null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumEqualTo(String value) {
            addCriterion("head_of_house_num =", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumNotEqualTo(String value) {
            addCriterion("head_of_house_num <>", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumGreaterThan(String value) {
            addCriterion("head_of_house_num >", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumGreaterThanOrEqualTo(String value) {
            addCriterion("head_of_house_num >=", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumLessThan(String value) {
            addCriterion("head_of_house_num <", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumLessThanOrEqualTo(String value) {
            addCriterion("head_of_house_num <=", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumLike(String value) {
            addCriterion("head_of_house_num like", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumNotLike(String value) {
            addCriterion("head_of_house_num not like", value, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumIn(List<String> values) {
            addCriterion("head_of_house_num in", values, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumNotIn(List<String> values) {
            addCriterion("head_of_house_num not in", values, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumBetween(String value1, String value2) {
            addCriterion("head_of_house_num between", value1, value2, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNumNotBetween(String value1, String value2) {
            addCriterion("head_of_house_num not between", value1, value2, "headOfHouseNum");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameIsNull() {
            addCriterion("head_of_house_name is null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameIsNotNull() {
            addCriterion("head_of_house_name is not null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameEqualTo(String value) {
            addCriterion("head_of_house_name =", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameNotEqualTo(String value) {
            addCriterion("head_of_house_name <>", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameGreaterThan(String value) {
            addCriterion("head_of_house_name >", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("head_of_house_name >=", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameLessThan(String value) {
            addCriterion("head_of_house_name <", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameLessThanOrEqualTo(String value) {
            addCriterion("head_of_house_name <=", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameLike(String value) {
            addCriterion("head_of_house_name like", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameNotLike(String value) {
            addCriterion("head_of_house_name not like", value, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameIn(List<String> values) {
            addCriterion("head_of_house_name in", values, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameNotIn(List<String> values) {
            addCriterion("head_of_house_name not in", values, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameBetween(String value1, String value2) {
            addCriterion("head_of_house_name between", value1, value2, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseNameNotBetween(String value1, String value2) {
            addCriterion("head_of_house_name not between", value1, value2, "headOfHouseName");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelIsNull() {
            addCriterion("head_of_house_tel is null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelIsNotNull() {
            addCriterion("head_of_house_tel is not null");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelEqualTo(String value) {
            addCriterion("head_of_house_tel =", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelNotEqualTo(String value) {
            addCriterion("head_of_house_tel <>", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelGreaterThan(String value) {
            addCriterion("head_of_house_tel >", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelGreaterThanOrEqualTo(String value) {
            addCriterion("head_of_house_tel >=", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelLessThan(String value) {
            addCriterion("head_of_house_tel <", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelLessThanOrEqualTo(String value) {
            addCriterion("head_of_house_tel <=", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelLike(String value) {
            addCriterion("head_of_house_tel like", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelNotLike(String value) {
            addCriterion("head_of_house_tel not like", value, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelIn(List<String> values) {
            addCriterion("head_of_house_tel in", values, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelNotIn(List<String> values) {
            addCriterion("head_of_house_tel not in", values, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelBetween(String value1, String value2) {
            addCriterion("head_of_house_tel between", value1, value2, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andHeadOfHouseTelNotBetween(String value1, String value2) {
            addCriterion("head_of_house_tel not between", value1, value2, "headOfHouseTel");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andStudyLevelIsNull() {
            addCriterion("study_level is null");
            return (Criteria) this;
        }

        public Criteria andStudyLevelIsNotNull() {
            addCriterion("study_level is not null");
            return (Criteria) this;
        }

        public Criteria andStudyLevelEqualTo(String value) {
            addCriterion("study_level =", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelNotEqualTo(String value) {
            addCriterion("study_level <>", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelGreaterThan(String value) {
            addCriterion("study_level >", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("study_level >=", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelLessThan(String value) {
            addCriterion("study_level <", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelLessThanOrEqualTo(String value) {
            addCriterion("study_level <=", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelLike(String value) {
            addCriterion("study_level like", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelNotLike(String value) {
            addCriterion("study_level not like", value, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelIn(List<String> values) {
            addCriterion("study_level in", values, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelNotIn(List<String> values) {
            addCriterion("study_level not in", values, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelBetween(String value1, String value2) {
            addCriterion("study_level between", value1, value2, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andStudyLevelNotBetween(String value1, String value2) {
            addCriterion("study_level not between", value1, value2, "studyLevel");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andClazzIsNull() {
            addCriterion("clazz is null");
            return (Criteria) this;
        }

        public Criteria andClazzIsNotNull() {
            addCriterion("clazz is not null");
            return (Criteria) this;
        }

        public Criteria andClazzEqualTo(String value) {
            addCriterion("clazz =", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotEqualTo(String value) {
            addCriterion("clazz <>", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThan(String value) {
            addCriterion("clazz >", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThanOrEqualTo(String value) {
            addCriterion("clazz >=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThan(String value) {
            addCriterion("clazz <", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThanOrEqualTo(String value) {
            addCriterion("clazz <=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLike(String value) {
            addCriterion("clazz like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotLike(String value) {
            addCriterion("clazz not like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzIn(List<String> values) {
            addCriterion("clazz in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotIn(List<String> values) {
            addCriterion("clazz not in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzBetween(String value1, String value2) {
            addCriterion("clazz between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotBetween(String value1, String value2) {
            addCriterion("clazz not between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNull() {
            addCriterion("student_number is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNotNull() {
            addCriterion("student_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberEqualTo(String value) {
            addCriterion("student_number =", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotEqualTo(String value) {
            addCriterion("student_number <>", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThan(String value) {
            addCriterion("student_number >", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("student_number >=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThan(String value) {
            addCriterion("student_number <", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThanOrEqualTo(String value) {
            addCriterion("student_number <=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLike(String value) {
            addCriterion("student_number like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotLike(String value) {
            addCriterion("student_number not like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIn(List<String> values) {
            addCriterion("student_number in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotIn(List<String> values) {
            addCriterion("student_number not in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberBetween(String value1, String value2) {
            addCriterion("student_number between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotBetween(String value1, String value2) {
            addCriterion("student_number not between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudyWayIsNull() {
            addCriterion("study_way is null");
            return (Criteria) this;
        }

        public Criteria andStudyWayIsNotNull() {
            addCriterion("study_way is not null");
            return (Criteria) this;
        }

        public Criteria andStudyWayEqualTo(String value) {
            addCriterion("study_way =", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayNotEqualTo(String value) {
            addCriterion("study_way <>", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayGreaterThan(String value) {
            addCriterion("study_way >", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayGreaterThanOrEqualTo(String value) {
            addCriterion("study_way >=", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayLessThan(String value) {
            addCriterion("study_way <", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayLessThanOrEqualTo(String value) {
            addCriterion("study_way <=", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayLike(String value) {
            addCriterion("study_way like", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayNotLike(String value) {
            addCriterion("study_way not like", value, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayIn(List<String> values) {
            addCriterion("study_way in", values, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayNotIn(List<String> values) {
            addCriterion("study_way not in", values, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayBetween(String value1, String value2) {
            addCriterion("study_way between", value1, value2, "studyWay");
            return (Criteria) this;
        }

        public Criteria andStudyWayNotBetween(String value1, String value2) {
            addCriterion("study_way not between", value1, value2, "studyWay");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityIsNull() {
            addCriterion("\"if_ disability\" is null");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityIsNotNull() {
            addCriterion("\"if_ disability\" is not null");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityEqualTo(Integer value) {
            addCriterion("\"if_ disability\" =", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityNotEqualTo(Integer value) {
            addCriterion("\"if_ disability\" <>", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityGreaterThan(Integer value) {
            addCriterion("\"if_ disability\" >", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"if_ disability\" >=", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityLessThan(Integer value) {
            addCriterion("\"if_ disability\" <", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityLessThanOrEqualTo(Integer value) {
            addCriterion("\"if_ disability\" <=", value, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityIn(List<Integer> values) {
            addCriterion("\"if_ disability\" in", values, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityNotIn(List<Integer> values) {
            addCriterion("\"if_ disability\" not in", values, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityBetween(Integer value1, Integer value2) {
            addCriterion("\"if_ disability\" between", value1, value2, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andIfDisabilityNotBetween(Integer value1, Integer value2) {
            addCriterion("\"if_ disability\" not between", value1, value2, "ifDisability");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberIsNull() {
            addCriterion("disability_number is null");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberIsNotNull() {
            addCriterion("disability_number is not null");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberEqualTo(String value) {
            addCriterion("disability_number =", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberNotEqualTo(String value) {
            addCriterion("disability_number <>", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberGreaterThan(String value) {
            addCriterion("disability_number >", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("disability_number >=", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberLessThan(String value) {
            addCriterion("disability_number <", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberLessThanOrEqualTo(String value) {
            addCriterion("disability_number <=", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberLike(String value) {
            addCriterion("disability_number like", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberNotLike(String value) {
            addCriterion("disability_number not like", value, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberIn(List<String> values) {
            addCriterion("disability_number in", values, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberNotIn(List<String> values) {
            addCriterion("disability_number not in", values, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberBetween(String value1, String value2) {
            addCriterion("disability_number between", value1, value2, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andDisabilityNumberNotBetween(String value1, String value2) {
            addCriterion("disability_number not between", value1, value2, "disabilityNumber");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonIsNull() {
            addCriterion("not_in_school_reason is null");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonIsNotNull() {
            addCriterion("not_in_school_reason is not null");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonEqualTo(String value) {
            addCriterion("not_in_school_reason =", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonNotEqualTo(String value) {
            addCriterion("not_in_school_reason <>", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonGreaterThan(String value) {
            addCriterion("not_in_school_reason >", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonGreaterThanOrEqualTo(String value) {
            addCriterion("not_in_school_reason >=", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonLessThan(String value) {
            addCriterion("not_in_school_reason <", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonLessThanOrEqualTo(String value) {
            addCriterion("not_in_school_reason <=", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonLike(String value) {
            addCriterion("not_in_school_reason like", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonNotLike(String value) {
            addCriterion("not_in_school_reason not like", value, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonIn(List<String> values) {
            addCriterion("not_in_school_reason in", values, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonNotIn(List<String> values) {
            addCriterion("not_in_school_reason not in", values, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonBetween(String value1, String value2) {
            addCriterion("not_in_school_reason between", value1, value2, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andNotInSchoolReasonNotBetween(String value1, String value2) {
            addCriterion("not_in_school_reason not between", value1, value2, "notInSchoolReason");
            return (Criteria) this;
        }

        public Criteria andPoorTypeIsNull() {
            addCriterion("poor_type is null");
            return (Criteria) this;
        }

        public Criteria andPoorTypeIsNotNull() {
            addCriterion("poor_type is not null");
            return (Criteria) this;
        }

        public Criteria andPoorTypeEqualTo(String value) {
            addCriterion("poor_type =", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeNotEqualTo(String value) {
            addCriterion("poor_type <>", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeGreaterThan(String value) {
            addCriterion("poor_type >", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("poor_type >=", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeLessThan(String value) {
            addCriterion("poor_type <", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeLessThanOrEqualTo(String value) {
            addCriterion("poor_type <=", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeLike(String value) {
            addCriterion("poor_type like", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeNotLike(String value) {
            addCriterion("poor_type not like", value, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeIn(List<String> values) {
            addCriterion("poor_type in", values, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeNotIn(List<String> values) {
            addCriterion("poor_type not in", values, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeBetween(String value1, String value2) {
            addCriterion("poor_type between", value1, value2, "poorType");
            return (Criteria) this;
        }

        public Criteria andPoorTypeNotBetween(String value1, String value2) {
            addCriterion("poor_type not between", value1, value2, "poorType");
            return (Criteria) this;
        }

        public Criteria andIfVillageIsNull() {
            addCriterion("if_village is null");
            return (Criteria) this;
        }

        public Criteria andIfVillageIsNotNull() {
            addCriterion("if_village is not null");
            return (Criteria) this;
        }

        public Criteria andIfVillageEqualTo(String value) {
            addCriterion("if_village =", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageNotEqualTo(String value) {
            addCriterion("if_village <>", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageGreaterThan(String value) {
            addCriterion("if_village >", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageGreaterThanOrEqualTo(String value) {
            addCriterion("if_village >=", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageLessThan(String value) {
            addCriterion("if_village <", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageLessThanOrEqualTo(String value) {
            addCriterion("if_village <=", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageLike(String value) {
            addCriterion("if_village like", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageNotLike(String value) {
            addCriterion("if_village not like", value, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageIn(List<String> values) {
            addCriterion("if_village in", values, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageNotIn(List<String> values) {
            addCriterion("if_village not in", values, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageBetween(String value1, String value2) {
            addCriterion("if_village between", value1, value2, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfVillageNotBetween(String value1, String value2) {
            addCriterion("if_village not between", value1, value2, "ifVillage");
            return (Criteria) this;
        }

        public Criteria andIfCountyIsNull() {
            addCriterion("if_county is null");
            return (Criteria) this;
        }

        public Criteria andIfCountyIsNotNull() {
            addCriterion("if_county is not null");
            return (Criteria) this;
        }

        public Criteria andIfCountyEqualTo(String value) {
            addCriterion("if_county =", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyNotEqualTo(String value) {
            addCriterion("if_county <>", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyGreaterThan(String value) {
            addCriterion("if_county >", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyGreaterThanOrEqualTo(String value) {
            addCriterion("if_county >=", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyLessThan(String value) {
            addCriterion("if_county <", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyLessThanOrEqualTo(String value) {
            addCriterion("if_county <=", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyLike(String value) {
            addCriterion("if_county like", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyNotLike(String value) {
            addCriterion("if_county not like", value, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyIn(List<String> values) {
            addCriterion("if_county in", values, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyNotIn(List<String> values) {
            addCriterion("if_county not in", values, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyBetween(String value1, String value2) {
            addCriterion("if_county between", value1, value2, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfCountyNotBetween(String value1, String value2) {
            addCriterion("if_county not between", value1, value2, "ifCounty");
            return (Criteria) this;
        }

        public Criteria andIfProvinceIsNull() {
            addCriterion("if_province is null");
            return (Criteria) this;
        }

        public Criteria andIfProvinceIsNotNull() {
            addCriterion("if_province is not null");
            return (Criteria) this;
        }

        public Criteria andIfProvinceEqualTo(String value) {
            addCriterion("if_province =", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceNotEqualTo(String value) {
            addCriterion("if_province <>", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceGreaterThan(String value) {
            addCriterion("if_province >", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("if_province >=", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceLessThan(String value) {
            addCriterion("if_province <", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceLessThanOrEqualTo(String value) {
            addCriterion("if_province <=", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceLike(String value) {
            addCriterion("if_province like", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceNotLike(String value) {
            addCriterion("if_province not like", value, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceIn(List<String> values) {
            addCriterion("if_province in", values, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceNotIn(List<String> values) {
            addCriterion("if_province not in", values, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceBetween(String value1, String value2) {
            addCriterion("if_province between", value1, value2, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andIfProvinceNotBetween(String value1, String value2) {
            addCriterion("if_province not between", value1, value2, "ifProvince");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyIsNull() {
            addCriterion("this_enjoy is null");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyIsNotNull() {
            addCriterion("this_enjoy is not null");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyEqualTo(String value) {
            addCriterion("this_enjoy =", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyNotEqualTo(String value) {
            addCriterion("this_enjoy <>", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyGreaterThan(String value) {
            addCriterion("this_enjoy >", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyGreaterThanOrEqualTo(String value) {
            addCriterion("this_enjoy >=", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyLessThan(String value) {
            addCriterion("this_enjoy <", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyLessThanOrEqualTo(String value) {
            addCriterion("this_enjoy <=", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyLike(String value) {
            addCriterion("this_enjoy like", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyNotLike(String value) {
            addCriterion("this_enjoy not like", value, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyIn(List<String> values) {
            addCriterion("this_enjoy in", values, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyNotIn(List<String> values) {
            addCriterion("this_enjoy not in", values, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyBetween(String value1, String value2) {
            addCriterion("this_enjoy between", value1, value2, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andThisEnjoyNotBetween(String value1, String value2) {
            addCriterion("this_enjoy not between", value1, value2, "thisEnjoy");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}