package de.fh.albsig.sauterse.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author Sebastian Sauter.
*
*/
@XmlRootElement
public class ExceptionData {
    /**
     * The exception name.
     */
    private String name;
    /**
     * The exception message.
     */
    private String message;

    /**
     * Default constructor.
     */
    public ExceptionData() {
        super();
    }

    /**
     *
     * @param pName the exception name.
     * @param pMessage the exception message.
     */
    public ExceptionData(final String pName, final String pMessage) {
        this.name = pName;
        this.message = pMessage;
    }

    /**
     *
     * @return name.
     */
    public final String getName() {
        return name;
    }

    /**
     *
     * @param pName set name.
     */
    @XmlElement
    public final void setName(final String pName) {
        this.name = pName;
    }

    /**
     *
     * @return message.
     */
    public final String getMessage() {
        return message;
    }

    /**
     *
     * @param pMessage set message.
     */
    @XmlElement
    public final void setMessage(final String pMessage) {
        this.message = pMessage;
    }
}
