package psidev.psi.mi.validator.extension.rules.psimi;

import psidev.psi.mi.jami.model.Annotation;
import psidev.psi.mi.jami.model.InteractionEvidence;
import psidev.psi.mi.validator.extension.Mi25Context;
import psidev.psi.mi.validator.extension.rules.RuleUtils;
import psidev.psi.tools.ontology_manager.OntologyManager;
import psidev.psi.tools.ontology_manager.interfaces.OntologyAccess;
import psidev.psi.tools.validator.MessageLevel;
import psidev.psi.tools.validator.ValidatorException;
import psidev.psi.tools.validator.ValidatorMessage;
import psidev.psi.tools.validator.rules.codedrule.ObjectRule;

import java.util.*;

/**
 * Rule to check that an interaction has valid annotation topics
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>27/03/13</pre>
 */

public class InteractionAnnotationTopicRule extends ObjectRule<InteractionEvidence> {
    public InteractionAnnotationTopicRule(OntologyManager ontologyManager) {
        super(ontologyManager);

        // describe the rule.
        setName("Interaction annotation topics Check");
        setDescription("Checks that the interaction annotations having a MI term are valid interaction annotation topics.");
        addTip( "Check http://www.ebi.ac.uk/ontology-lookup/browse.do?ontName=MI&termId=MI%3A0664&termName=interaction%20att%20name for interaction attribute names" );
        addTip( "Check http://www.ebi.ac.uk/ontology-lookup/browse.do?ontName=MI&termId=MI%3A0954&termName=curation%20quality for curation quality" );
        addTip( "Check http://www.ebi.ac.uk/ontology-lookup/browse.do?ontName=MI&termId=MI%3A1045&termName=curation%20content for curation content" );
    }

    @Override
    public boolean canCheck(Object t) {
        return t instanceof InteractionEvidence;
    }

    @Override
    public Collection<ValidatorMessage> check(InteractionEvidence interactionEvidence) throws ValidatorException {

        if (!interactionEvidence.getAnnotations().isEmpty()){
            // list of messages to return
            List<ValidatorMessage> messages = new ArrayList<ValidatorMessage>();
            Mi25Context context = RuleUtils.buildContext(interactionEvidence, "interaction");

            for (Annotation annot : interactionEvidence.getAnnotations()){
                if (annot.getTopic()!= null && annot.getTopic().getMIIdentifier() != null){
                    final OntologyAccess access = ontologyManager.getOntologyAccess("MI");
                    Set<String> dbTerms = RuleUtils.collectAccessions(access.getValidTerms("MI:0664", true, false));
                    dbTerms.addAll(RuleUtils.collectAccessions(access.getValidTerms("MI:1045", true, false)));
                    dbTerms.addAll(RuleUtils.collectAccessions(access.getValidTerms("MI:0954", true, false)));

                    if (!dbTerms.contains(annot.getTopic().getMIIdentifier())){
                        context.addAssociatedContext(RuleUtils.buildContext(annot, "annotation"));
                        messages.add( new ValidatorMessage( "The annotation topic "+annot.getTopic()+" is not a valid annotation topic for interactions",
                                MessageLevel.WARN,
                                context,
                                this ) );
                    }
                }
            }

            return messages;
        }

        return Collections.EMPTY_LIST;
    }

    public String getId() {
        return "R38";
    }
}