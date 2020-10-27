package com.mizhi.yxd.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SubSubsidizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubSubsidizeExample() {
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

        public Criteria andPoorIdIsNull() {
            addCriterion("poor_id is null");
            return (Criteria) this;
        }

        public Criteria andPoorIdIsNotNull() {
            addCriterion("poor_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoorIdEqualTo(String value) {
            addCriterion("poor_id =", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdNotEqualTo(String value) {
            addCriterion("poor_id <>", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdGreaterThan(String value) {
            addCriterion("poor_id >", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdGreaterThanOrEqualTo(String value) {
            addCriterion("poor_id >=", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdLessThan(String value) {
            addCriterion("poor_id <", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdLessThanOrEqualTo(String value) {
            addCriterion("poor_id <=", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdLike(String value) {
            addCriterion("poor_id like", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdNotLike(String value) {
            addCriterion("poor_id not like", value, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdIn(List<String> values) {
            addCriterion("poor_id in", values, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdNotIn(List<String> values) {
            addCriterion("poor_id not in", values, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdBetween(String value1, String value2) {
            addCriterion("poor_id between", value1, value2, "poorId");
            return (Criteria) this;
        }

        public Criteria andPoorIdNotBetween(String value1, String value2) {
            addCriterion("poor_id not between", value1, value2, "poorId");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectIsNull() {
            addCriterion("subsidize_project is null");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectIsNotNull() {
            addCriterion("subsidize_project is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectEqualTo(String value) {
            addCriterion("subsidize_project =", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectNotEqualTo(String value) {
            addCriterion("subsidize_project <>", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectGreaterThan(String value) {
            addCriterion("subsidize_project >", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectGreaterThanOrEqualTo(String value) {
            addCriterion("subsidize_project >=", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectLessThan(String value) {
            addCriterion("subsidize_project <", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectLessThanOrEqualTo(String value) {
            addCriterion("subsidize_project <=", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectLike(String value) {
            addCriterion("subsidize_project like", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectNotLike(String value) {
            addCriterion("subsidize_project not like", value, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectIn(List<String> values) {
            addCriterion("subsidize_project in", values, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectNotIn(List<String> values) {
            addCriterion("subsidize_project not in", values, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectBetween(String value1, String value2) {
            addCriterion("subsidize_project between", value1, value2, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeProjectNotBetween(String value1, String value2) {
            addCriterion("subsidize_project not between", value1, value2, "subsidizeProject");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyIsNull() {
            addCriterion("subsidize_money is null");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyIsNotNull() {
            addCriterion("subsidize_money is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyEqualTo(BigDecimal value) {
            addCriterion("subsidize_money =", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("subsidize_money <>", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyGreaterThan(BigDecimal value) {
            addCriterion("subsidize_money >", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subsidize_money >=", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyLessThan(BigDecimal value) {
            addCriterion("subsidize_money <", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subsidize_money <=", value, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyIn(List<BigDecimal> values) {
            addCriterion("subsidize_money in", values, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("subsidize_money not in", values, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subsidize_money between", value1, value2, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andSubsidizeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subsidize_money not between", value1, value2, "subsidizeMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyIsNull() {
            addCriterion("nutrimeal_money is null");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyIsNotNull() {
            addCriterion("nutrimeal_money is not null");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyEqualTo(BigDecimal value) {
            addCriterion("nutrimeal_money =", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyNotEqualTo(BigDecimal value) {
            addCriterion("nutrimeal_money <>", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyGreaterThan(BigDecimal value) {
            addCriterion("nutrimeal_money >", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nutrimeal_money >=", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyLessThan(BigDecimal value) {
            addCriterion("nutrimeal_money <", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nutrimeal_money <=", value, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyIn(List<BigDecimal> values) {
            addCriterion("nutrimeal_money in", values, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyNotIn(List<BigDecimal> values) {
            addCriterion("nutrimeal_money not in", values, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nutrimeal_money between", value1, value2, "nutrimealMoney");
            return (Criteria) this;
        }

        public Criteria andNutrimealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nutrimeal_money not between", value1, value2, "nutrimealMoney");
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