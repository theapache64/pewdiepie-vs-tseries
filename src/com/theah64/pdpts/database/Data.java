package com.theah64.pdpts.database;

import com.theah64.pdpts.pojos.DataBean;
import com.theah64.webengine.database.BaseTable;
import com.theah64.webengine.database.querybuilders.AddQueryBuilder;
import com.theah64.webengine.database.querybuilders.QueryBuilderException;
import com.theah64.webengine.database.querybuilders.SelectQueryBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Data extends BaseTable<DataBean> {

    private static final String COLUMN_PDP_SUB = "pdp_sub";
    private static final String COLUMN_TS_SUB = "ts_sub";
    private static Data instance = new Data();

    private Data() {
        super("data");
    }

    public static Data getInstance() {
        return instance;
    }

    @Override
    public boolean add(DataBean data) throws SQLException, QueryBuilderException {
        return new AddQueryBuilder.Builder(getTableName())
                .add(COLUMN_PDP_SUB, data.getPdpSub())
                .add(COLUMN_TS_SUB, data.getTsSub())
                .done();
    }

    public List<DataBean> getAll(int limit) throws QueryBuilderException, SQLException {

        return new SelectQueryBuilder.Builder<>(getTableName(), new SelectQueryBuilder.Callback<DataBean>() {
            @Override
            public DataBean getNode(ResultSet rs) throws SQLException {
                return new DataBean(
                        rs.getString(COLUMN_ID),
                        rs.getString(COLUMN_PDP_SUB),
                        rs.getString(COLUMN_TS_SUB),
                        rs.getString(COLUMN_CREATED_AT)
                );
            }
        })
                .select(new String[]{COLUMN_ID, COLUMN_PDP_SUB, COLUMN_TS_SUB, COLUMN_CREATED_AT})
                .orderBy(COLUMN_ID + " DESC")
                .limit(limit)
                .build()
                .getAll();
    }
}
