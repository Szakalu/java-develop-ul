package pl.lodz.uni.math.daofactory;

public class DaoFactory {

	private Source sourceOfData;

	public DaoFactory() {
	}

	public void setSourceOfData(EnumSourceDaoFactory source) {
		switch (source) {
		case DB:
			sourceOfData = DbSource.getInstance();
			break;
		case XML:
			sourceOfData = XmlSource.getInstance();
			break;
		case WS:
			sourceOfData = WsSource.getInstance();
			break;
		default:
			break;
		}
	}

	public Source getSourceOfData() {
		return sourceOfData;

	}

}
