package com.theah64.pdpts.database;

import com.theah64.pdpts.pojos.DataBean;
import com.theah64.webengine.database.BaseTable;
import com.theah64.webengine.database.querybuilders.AddQueryBuilder;
import com.theah64.webengine.database.querybuilders.QueryBuilderException;

import java.sql.SQLException;

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
}
