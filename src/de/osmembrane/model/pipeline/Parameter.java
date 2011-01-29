package de.osmembrane.model.pipeline;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

import de.osmembrane.model.Identifier;
import de.osmembrane.model.ModelProxy;
import de.osmembrane.model.xml.XMLEnumValue;
import de.osmembrane.model.xml.XMLParameter;
import de.osmembrane.tools.I18N;

/**
 * Implemenation of {@link AbstractParameter}.
 * 
 * @author jakob_jarosch
 */
public class Parameter extends AbstractParameter {

	private static final long serialVersionUID = 2011011821310001L;

	/**
	 * The XML counterpart of the parameter.
	 */
	transient private XMLParameter xmlParam;
	private Identifier xmlParamIdentifier;
	
	/**
	 * The enum values for the parameter (if {@link Parameter#type} is {@link ParameterType#ENUM}).
	 */
	private List<EnumValue> enumValues = new ArrayList<EnumValue>();
	
	/**
	 * Type of the parameter.
	 */
	private ParameterType type;
	
	/**
	 * Value of the Parameter.
	 */
	private String value;
	
	/**
	 * Constructor for a new {@link Parameter}.
	 * 
	 * @param xmlParam XML counterpart which should be represented by the {@link Parameter}.
	 */
	public Parameter(XMLParameter xmlParam) {
		this.type = ParameterType.parseString(xmlParam.getType());
		this.value = xmlParam.getDefaultValue();
		this.xmlParam = xmlParam;
		
		/* set the identifiers */
		AbstractFunctionPrototype afp = ModelProxy.getInstance().accessFunctions();
		this.xmlParamIdentifier = afp.getMatchingXMLParameterIdentifier(this.xmlParam);
		
		/* create enum values */
		for(XMLEnumValue xmlEnum : xmlParam.getEnumValue()) {
			enumValues.add(new EnumValue(xmlEnum));
		}
	}

	@Override
	public String getName() {
		return xmlParam.getName();
	}

	@Override
	public String getFriendlyName() {
		/* fallback when friendlyName is not available */
		if(xmlParam.getFriendlyName() == null) {
			return getName();
		}
		
		return xmlParam.getFriendlyName();
	}
	
	@Override
	public String getDescription() {
		return I18N.getInstance().getDescription(xmlParam);
	}
	
	@Override
	public ParameterType getType() {
		return type;
	}

	@Override
	public AbstractEnumValue[] getEnumValue() {
		EnumValue[] values = new EnumValue[enumValues.size()];
		return enumValues.toArray(values);
	}

	@Override
	public String getDefaultValue() {
		return xmlParam.getDefaultValue();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public boolean setValue(String value) {
		// TODO check the type match for parameter values
		this.value = value;
		
		setChanged();
		notifyObservers();
		
		return true;
	}

	@Override
	public boolean isRequired() {
		return xmlParam.isRequired();
	}

	@Override
	public boolean isDefaultParameter() {
		return xmlParam.isDefaulXMLParameter();
	}

	@Override
	public Parameter copy(CopyType type) {
		Parameter newParam = new Parameter(this.xmlParam);
		
		/* copy the param-value */
		if(type.copyValues()) {
			newParam.value = this.value;
		}
		
		return newParam;
	}
	
	private Object readResolve() throws ObjectStreamException {
		AbstractFunctionPrototype afp = ModelProxy.getInstance().accessFunctions();
		this.xmlParam = afp.getMatchingXMLParameter(this.xmlParamIdentifier);
		
		return this;
	}
}
