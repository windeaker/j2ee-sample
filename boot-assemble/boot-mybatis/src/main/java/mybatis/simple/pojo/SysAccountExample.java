package mybatis.simple.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAccountExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Byte value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Byte value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Byte value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Byte value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Byte> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Byte> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Byte value1, Byte value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andCstCreatedIsNull() {
            addCriterion("cst_created is null");
            return (Criteria) this;
        }

        public Criteria andCstCreatedIsNotNull() {
            addCriterion("cst_created is not null");
            return (Criteria) this;
        }

        public Criteria andCstCreatedEqualTo(Date value) {
            addCriterion("cst_created =", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedNotEqualTo(Date value) {
            addCriterion("cst_created <>", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedGreaterThan(Date value) {
            addCriterion("cst_created >", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("cst_created >=", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedLessThan(Date value) {
            addCriterion("cst_created <", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedLessThanOrEqualTo(Date value) {
            addCriterion("cst_created <=", value, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedIn(List<Date> values) {
            addCriterion("cst_created in", values, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedNotIn(List<Date> values) {
            addCriterion("cst_created not in", values, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedBetween(Date value1, Date value2) {
            addCriterion("cst_created between", value1, value2, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstCreatedNotBetween(Date value1, Date value2) {
            addCriterion("cst_created not between", value1, value2, "cstCreated");
            return (Criteria) this;
        }

        public Criteria andCstModifiedIsNull() {
            addCriterion("cst_modified is null");
            return (Criteria) this;
        }

        public Criteria andCstModifiedIsNotNull() {
            addCriterion("cst_modified is not null");
            return (Criteria) this;
        }

        public Criteria andCstModifiedEqualTo(Date value) {
            addCriterion("cst_modified =", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedNotEqualTo(Date value) {
            addCriterion("cst_modified <>", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedGreaterThan(Date value) {
            addCriterion("cst_modified >", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("cst_modified >=", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedLessThan(Date value) {
            addCriterion("cst_modified <", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedLessThanOrEqualTo(Date value) {
            addCriterion("cst_modified <=", value, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedIn(List<Date> values) {
            addCriterion("cst_modified in", values, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedNotIn(List<Date> values) {
            addCriterion("cst_modified not in", values, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedBetween(Date value1, Date value2) {
            addCriterion("cst_modified between", value1, value2, "cstModified");
            return (Criteria) this;
        }

        public Criteria andCstModifiedNotBetween(Date value1, Date value2) {
            addCriterion("cst_modified not between", value1, value2, "cstModified");
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPwdDigestIsNull() {
            addCriterion("pwd_digest is null");
            return (Criteria) this;
        }

        public Criteria andPwdDigestIsNotNull() {
            addCriterion("pwd_digest is not null");
            return (Criteria) this;
        }

        public Criteria andPwdDigestEqualTo(String value) {
            addCriterion("pwd_digest =", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestNotEqualTo(String value) {
            addCriterion("pwd_digest <>", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestGreaterThan(String value) {
            addCriterion("pwd_digest >", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestGreaterThanOrEqualTo(String value) {
            addCriterion("pwd_digest >=", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestLessThan(String value) {
            addCriterion("pwd_digest <", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestLessThanOrEqualTo(String value) {
            addCriterion("pwd_digest <=", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestLike(String value) {
            addCriterion("pwd_digest like", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestNotLike(String value) {
            addCriterion("pwd_digest not like", value, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestIn(List<String> values) {
            addCriterion("pwd_digest in", values, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestNotIn(List<String> values) {
            addCriterion("pwd_digest not in", values, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestBetween(String value1, String value2) {
            addCriterion("pwd_digest between", value1, value2, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andPwdDigestNotBetween(String value1, String value2) {
            addCriterion("pwd_digest not between", value1, value2, "pwdDigest");
            return (Criteria) this;
        }

        public Criteria andDigestSaltIsNull() {
            addCriterion("digest_salt is null");
            return (Criteria) this;
        }

        public Criteria andDigestSaltIsNotNull() {
            addCriterion("digest_salt is not null");
            return (Criteria) this;
        }

        public Criteria andDigestSaltEqualTo(String value) {
            addCriterion("digest_salt =", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltNotEqualTo(String value) {
            addCriterion("digest_salt <>", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltGreaterThan(String value) {
            addCriterion("digest_salt >", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltGreaterThanOrEqualTo(String value) {
            addCriterion("digest_salt >=", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltLessThan(String value) {
            addCriterion("digest_salt <", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltLessThanOrEqualTo(String value) {
            addCriterion("digest_salt <=", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltLike(String value) {
            addCriterion("digest_salt like", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltNotLike(String value) {
            addCriterion("digest_salt not like", value, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltIn(List<String> values) {
            addCriterion("digest_salt in", values, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltNotIn(List<String> values) {
            addCriterion("digest_salt not in", values, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltBetween(String value1, String value2) {
            addCriterion("digest_salt between", value1, value2, "digestSalt");
            return (Criteria) this;
        }

        public Criteria andDigestSaltNotBetween(String value1, String value2) {
            addCriterion("digest_salt not between", value1, value2, "digestSalt");
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