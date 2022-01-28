package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockOrTrapType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(BlockOrTrapType.class);
    private static final List<BlockOrTrapType> VALUES_LIST = new CopyOnWriteArrayList();

    public BlockOrTrapType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static BlockOrTrapType find(String scheme, String value) throws ServiceException {
        return (BlockOrTrapType)find(scheme, value, VALUES_LIST, BlockOrTrapType.class);
    }
}
