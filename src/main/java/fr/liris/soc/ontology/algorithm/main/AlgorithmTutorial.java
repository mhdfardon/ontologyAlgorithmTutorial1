package fr.liris.soc.ontology.algorithm.main;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by mhdfa on 02-Dec-17.
 */
public class AlgorithmTutorial {

    private static final Logger log = LoggerFactory.getLogger(AlgorithmTutorial.class);


    public static void main(String args[]) {

        OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF, null);

        String NS = "http://www.abc.com/abcportal/abc.owl" + "#";

        base.read("HealthOntologies/home.owl");

        ExtendedIterator<ObjectProperty> listObjectProperties = base.listObjectProperties();
//        List<ObjectProperty> list = listObjectProperties.toList();
        while (listObjectProperties.hasNext()) {
            ObjectProperty objectProperty = listObjectProperties.next();

            String propertyLocalName = objectProperty.getLocalName();
            if ("hasBeginning".equals(propertyLocalName)) {
                log.info("Local Name = " + propertyLocalName);
                OntResource domain = objectProperty.getDomain();

                OntResource range = objectProperty.getRange();
                OntProperty equivalentProperty = objectProperty.getEquivalentProperty();
                OntProperty subProperty = objectProperty.getSubProperty();
                OntProperty superProperty = objectProperty.getSuperProperty();
                String versionInfo = objectProperty.getVersionInfo();
                List<? extends OntResource> listDomain = objectProperty.listDomain().toList();

                List<? extends OntResource> listRange =  objectProperty.listRange().toList();
                List<? extends OntClass> listDeclaringClasses = objectProperty.listDeclaringClasses().toList();
                Set<RDFNode> listIsDefinedBy = objectProperty.listIsDefinedBy().toSet();
                Set<? extends OntProperty> listSubProperties = objectProperty.listSubProperties().toSet();
                List<? extends Resource> listSameAs = objectProperty.listSameAs().toList();
                objectProperty.getVersionInfo();
            }

        }

//        ExtendedIterator<OntProperty> listOntProperties = base.listAllOntProperties();
//        while(listOntProperties.hasNext()) {
//            OntProperty ontProp = listOntProperties.next();
//            log.info("Local Name = " + ontProp.getLocalName());
//
//        }

//        base.listResourcesWithProperty()

//        ExtendedIterator<OntClass> classesIter = base.listClasses();

//        while (classesIter.hasNext()) {
//            OntClass ontClass = classesIter.next();

//            System.out.println(ontClass.getLocalName().trim());

//            String ontClassLocalName = ontClass.getLocalName();
//            if(ontClassLocalName != null) {
//
//            log.info(ontClassLocalName.toString());
//            if("TimeZone".equals(ontClassLocalName.toString())) {
//                log.info(ontClass.getURI());
//            }
//            } else {
//                log.info(ontClass.toString());
//            }
//            ExtendedIterator<OntProperty> propertiesIter = ontClass.listDeclaredProperties();
////            StmtIterator propertiesIter = ontClass.listProperties();
//            while (propertiesIter.hasNext()) {
//                OntProperty prop = propertiesIter.next();
//
//                NodeIterator propValuesIter = ontClass.listPropertyValues(prop);
//                while (propValuesIter.hasNext()) {
//                    RDFNode propValue = propValuesIter.next();
//                    log.info("property label = " + prop.getNameSpace() + " property value = " + propValue.toString());
//                }
//            }

//        }

//        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
   /*     Model model = ModelFactory.createDefaultModel();
        model.read("m3.owl");
        model.list*/
    }
}
