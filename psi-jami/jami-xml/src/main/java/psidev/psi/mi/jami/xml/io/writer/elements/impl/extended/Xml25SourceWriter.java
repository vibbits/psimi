package psidev.psi.mi.jami.xml.io.writer.elements.impl.extended;

import psidev.psi.mi.jami.model.Alias;
import psidev.psi.mi.jami.model.Annotation;
import psidev.psi.mi.jami.model.Source;
import psidev.psi.mi.jami.xml.model.extension.ExtendedPsi25Source;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXmlElementWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXmlPublicationWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXmlXrefWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.impl.XmlSourceWriter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * XML 2.5 writer for extended XML source having a release description and a release date
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>13/11/13</pre>
 */

public class Xml25SourceWriter extends XmlSourceWriter {
    public Xml25SourceWriter(XMLStreamWriter writer) {
        super(writer);
    }

    public Xml25SourceWriter(XMLStreamWriter writer, PsiXmlElementWriter<Alias> aliasWriter,
                             PsiXmlPublicationWriter publicationWriter, PsiXmlXrefWriter primaryRefWriter,
                             PsiXmlXrefWriter secondaryRefWriter, PsiXmlElementWriter<Annotation> attributeWriter) {
        super(writer, aliasWriter, publicationWriter, primaryRefWriter, secondaryRefWriter, attributeWriter);
    }

    @Override
    protected void writeReleaseAttributes(Source object) throws XMLStreamException {
        ExtendedPsi25Source xmlSource = (ExtendedPsi25Source) object;
        if (xmlSource.getRelease() != null){
            getStreamWriter().writeAttribute("release", xmlSource.getRelease());
        }
        if (xmlSource.getReleaseDate() != null){
            getStreamWriter().writeAttribute("releaseDate", xmlSource.getReleaseDate().toXMLFormat());
        }
        else{
            super.writeReleaseAttributes(object);
        }
    }
}
