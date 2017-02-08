package pl.lodz.uni.math.daofactory;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

	private Source sourceOfData;
	Map<EnumSourceDaoFactory, Source> sources = new HashMap<EnumSourceDaoFactory, Source>();

	public DaoFactory() {
		sources.put(EnumSourceDaoFactory.DB,DbSource.getInstance());
		sources.put(EnumSourceDaoFactory.WS,WsSource.getInstance());
		sources.put(EnumSourceDaoFactory.XML,XmlSource.getInstance());
	}

	public void setSourceOfData(EnumSourceDaoFactory source) {
		sourceOfData = sources.get(source);
	}

	public Source getSourceOfData() {
		return sourceOfData;

	}

}
