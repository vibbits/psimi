package psidev.psi.mi.tab.model.builder;

import junit.framework.Assert;
import org.junit.Test;
import psidev.psi.mi.tab.model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ntoro
 * Date: 16/07/2012
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public class MitabWriterUtilsTest {

	@Test(expected = IllegalArgumentException.class)
    public void testBuildHeaderException() throws Exception {

        MitabWriterUtils.buildHeader(null);
    }


    @Test
    public void testBuildLine() throws Exception {
        String result1 = MitabWriterUtils.buildLine(buildInteraction(), PsimiTabVersion.v2_5);
        Assert.assertEquals(result1, MitabWriterUtils.createMitabLine(line25, PsimiTabVersion.v2_5));

        String result2 = MitabWriterUtils.buildLine(buildInteraction(), PsimiTabVersion.v2_6);
        Assert.assertEquals(result2, MitabWriterUtils.createMitabLine(line26, PsimiTabVersion.v2_6));

        String result3 = MitabWriterUtils.buildLine(buildInteraction(), PsimiTabVersion.v2_7);
        Assert.assertEquals(result3, MitabWriterUtils.createMitabLine(line27, PsimiTabVersion.v2_7));

        String result4 = MitabWriterUtils.buildLine(buildInteraction(), PsimiTabVersion.v2_8);
        Assert.assertEquals(result4, MitabWriterUtils.createMitabLine(line28, PsimiTabVersion.v2_8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildLineException() throws Exception {
        MitabWriterUtils.buildLine(buildInteraction(), null);
    }

	@Test
	public void testIntraIterMoleculeInteractionLine() throws Exception {
		String result1 = MitabWriterUtils.buildLine(buildIntraIterMoleculeAInteraction(), PsimiTabVersion.v2_8);
		Assert.assertEquals(result1, MitabWriterUtils.createMitabLine(interactorBNull, PsimiTabVersion.v2_8));

		String result2 = MitabWriterUtils.buildLine(buildIntraIterMoleculeBInteraction(), PsimiTabVersion.v2_8);
		Assert.assertEquals(result2, MitabWriterUtils.createMitabLine(interactorANull, PsimiTabVersion.v2_8));
	}


	private String[] line25 = {
			"innatedb:IDBG-40102",
			"innatedb:IDBG-4279",
			"ensembl:ENSG00000175104",
			"ensembl:ENSG00000141655",
			"uniprotkb:Q9Y4K3|uniprotkb:TRAF6_HUMAN|refseq:NM_145803|refseq:NM_004620|refseq:NP_004611|refseq:NP_665802|hgnc:TNFRSF11A(display_short)",
			"uniprotkb:Q9Y6Q6|uniprotkb:TNR11_HUMAN|refseq:NM_003839|refseq:NP_003830|hgnc:TNFRSF11A(display_short)",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"taxid:9606(Human)",
			"taxid:9606(Human)",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1"
	};

	private String[] line26 = {
			"innatedb:IDBG-40102",
			"innatedb:IDBG-4279",
			"ensembl:ENSG00000175104",
			"ensembl:ENSG00000141655",
			"uniprotkb:Q9Y4K3|uniprotkb:TRAF6_HUMAN|refseq:NM_145803|refseq:NM_004620|refseq:NP_004611|refseq:NP_665802|hgnc:TNFRSF11A(display_short)",
			"uniprotkb:Q9Y6Q6|uniprotkb:TNR11_HUMAN|refseq:NM_003839|refseq:NP_003830|hgnc:TNFRSF11A(display_short)",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"taxid:9606(Human)",
			"taxid:9606(Human)",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1",
			"psi-mi:\"MI:1060\"(spoke expansion)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0498\"(prey)",
			"psi-mi:\"MI:0496\"(bait)",
			"psi-mi:\"MI:0326\"(protein)",
			"psi-mi:\"MI:0326\"(protein)",
			"uniprotkb:D3DRX9(secondary-ac)",
			"refseq:NP_001447.2",
			"intact:EBI-5627041(see-also)|imex:IM-17229-3(imex-primary)",
			"-",
			"-",
			"curation depth:imex curation",
			"taxid:9606",
			"kd:1.36x10^-6(molar)",
			"2008/03/30",
			"2008/03/30",
			"crc64:6C1A07041DF50142",
			"crc64:2F6FEFCDF2C80457",
			"intact-crc:08C4486B755C70C0",
			"false"
	};

	private String[] line27 = {
			"innatedb:IDBG-40102",
			"innatedb:IDBG-4279",
			"ensembl:ENSG00000175104",
			"ensembl:ENSG00000141655",
			"uniprotkb:Q9Y4K3|uniprotkb:TRAF6_HUMAN|refseq:NM_145803|refseq:NM_004620|refseq:NP_004611|refseq:NP_665802|hgnc:TNFRSF11A(display_short)",
			"uniprotkb:Q9Y6Q6|uniprotkb:TNR11_HUMAN|refseq:NM_003839|refseq:NP_003830|hgnc:TNFRSF11A(display_short)",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"taxid:9606(Human)",
			"taxid:9606(Human)",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1",
			"psi-mi:\"MI:1060\"(spoke expansion)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0498\"(prey)",
			"psi-mi:\"MI:0496\"(bait)",
			"psi-mi:\"MI:0326\"(protein)",
			"psi-mi:\"MI:0326\"(protein)",
			"uniprotkb:D3DRX9(secondary-ac)",
			"refseq:NP_001447.2",
			"intact:EBI-5627041(see-also)|imex:IM-17229-3(imex-primary)",
			"-",
			"-",
			"curation depth:imex curation",
			"taxid:9606",
			"kd:1.36x10^-6(molar)",
			"2008/03/30",
			"2008/03/30",
			"crc64:6C1A07041DF50142",
			"crc64:2F6FEFCDF2C80457",
			"intact-crc:08C4486B755C70C0",
			"false",
			"necessary binding region:2171-2647",
			"necessary binding region:757-800",
			"-",
			"-",
			"psi-mi:\"MI:0363\"(inferred by author)",
			"psi-mi:\"MI:0363\"(inferred by author)"
	};

	private String[] line28 = {
			"innatedb:IDBG-40102",
			"innatedb:IDBG-4279",
			"ensembl:ENSG00000175104",
			"ensembl:ENSG00000141655",
			"uniprotkb:Q9Y4K3|uniprotkb:TRAF6_HUMAN|refseq:NM_145803|refseq:NM_004620|refseq:NP_004611|refseq:NP_665802|hgnc:TNFRSF11A(display_short)",
			"uniprotkb:Q9Y6Q6|uniprotkb:TNR11_HUMAN|refseq:NM_003839|refseq:NP_003830|hgnc:TNFRSF11A(display_short)",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"taxid:9606(Human)",
			"taxid:9606(Human)",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1",
			"psi-mi:\"MI:1060\"(spoke expansion)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"psi-mi:\"MI:0498\"(prey)",
			"psi-mi:\"MI:0496\"(bait)",
			"psi-mi:\"MI:0326\"(protein)",
			"psi-mi:\"MI:0326\"(protein)",
			"uniprotkb:D3DRX9(secondary-ac)",
			"refseq:NP_001447.2",
			"intact:EBI-5627041(see-also)|imex:IM-17229-3(imex-primary)",
			"-",
			"-",
			"curation depth:imex curation",
			"taxid:9606",
			"kd:1.36x10^-6(molar)",
			"2008/03/30",
			"2008/03/30",
			"crc64:6C1A07041DF50142",
			"crc64:2F6FEFCDF2C80457",
			"intact-crc:08C4486B755C70C0",
			"false",
			"necessary binding region:2171-2647",
			"necessary binding region:757-800",
			"-",
			"-",
			"psi-mi:\"MI:0363\"(inferred by author)",
			"psi-mi:\"MI:0363\"(inferred by author)",
			"go:\"GO:0016301\"(kinase activity)",
			"go:\"GO:0016301\"(kinase activity)",
			"psi-mi:\"MI:2249\"(post transcriptional regulation)",
			"psi-mi:\"MI:2240\"(down regulates)"
	};

	private String[] interactorANull = {
			"-",
			"innatedb:IDBG-4279",
			"-",
			"ensembl:ENSG00000141655",
			"-",
			"uniprotkb:Q9Y6Q6",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"-",
			"taxid:9606(Human)",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1",
			"psi-mi:\"MI:1060\"(spoke expansion)",
			"-",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"-",
			"psi-mi:\"MI:0496\"(bait)",
			"-",
			"psi-mi:\"MI:0326\"(protein)",
			"-",
			"refseq:NP_001447.2",
			"intact:EBI-5627041(see-also)|imex:IM-17229-3(imex-primary)",
			"-",
			"-",
			"curation depth:imex curation",
			"taxid:9606",
			"kd:1.36x10^-6(molar)",
			"2008/03/30",
			"2008/03/30",
			"-",
			"crc64:2F6FEFCDF2C80457",
			"intact-crc:08C4486B755C70C0",
			"false",
			"-",
			"necessary binding region:757-800",
			"-",
			"2",
			"-",
			"psi-mi:\"MI:0363\"(inferred by author)",
			"-",
			"go:\"GO:0016301\"(kinase activity)",
			"psi-mi:\"MI:2249\"(post transcriptional regulation)",
			"psi-mi:\"MI:2240\"(down regulates)"
	};

	private String[] interactorBNull = {
			"innatedb:IDBG-40102",
			"-",
			"ensembl:ENSG00000175104",
			"-",
			"uniprotkb:Q9Y4K3",
			"-",
			"psi-mi:\"MI:0007\"(anti tag coimmunoprecipitation)",
			"Arron et al. (2001)",
			"pubmed:11406619",
			"taxid:9606(Human)",
			"-",
			"psi-mi:\"MI:0915\"(physical association)",
			"psi-mi:\"MI:0974\"(innatedb)",
			"innatedb:IDB-113260",
			"lpr:2|hpr:2|np:1",
			"psi-mi:\"MI:1060\"(spoke expansion)",
			"psi-mi:\"MI:0499\"(unspecified role)",
			"-",
			"psi-mi:\"MI:0498\"(prey)",
			"-",
			"psi-mi:\"MI:0326\"(protein)",
			"-",
			"uniprotkb:D3DRX9(secondary-ac)",
			"-",
			"intact:EBI-5627041(see-also)|imex:IM-17229-3(imex-primary)",
			"-",
			"-",
			"curation depth:imex curation",
			"taxid:9606",
			"kd:1.36x10^-6(molar)",
			"2008/03/30",
			"2008/03/30",
			"crc64:6C1A07041DF50142",
			"-",
			"intact-crc:08C4486B755C70C0",
			"false",
			"necessary binding region:2171-2647",
			"-",
			"2",
			"-",
			"psi-mi:\"MI:0363\"(inferred by author)",
			"-",
			"go:\"GO:0016301\"(kinase activity)",
			"-",
			"psi-mi:\"MI:2249\"(post transcriptional regulation)",
			"psi-mi:\"MI:2240\"(down regulates)"
	};


	private BinaryInteraction<Interactor> buildInteraction() {

		Interactor A = new Interactor();
		Interactor B = new Interactor();

		BinaryInteraction<Interactor> interactionToCompare = new BinaryInteractionImpl(A, B);

		// MITAB 2.5
		A.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDBG-40102"))));
		B.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDBG-4279"))));
		A.setAlternativeIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("ensembl", "ENSG00000175104"))));
		B.setAlternativeIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("ensembl", "ENSG00000141655"))));

		List<Alias> aliasesA = new ArrayList<Alias>() {{
			add(new AliasImpl("uniprotkb", "Q9Y4K3"));
			add(new AliasImpl("uniprotkb", "TRAF6_HUMAN"));
			add(new AliasImpl("refseq", "NM_145803"));
			add(new AliasImpl("refseq", "NM_004620"));
			add(new AliasImpl("refseq", "NP_004611"));
			add(new AliasImpl("refseq", "NP_665802"));
			add(new AliasImpl("hgnc", "TNFRSF11A", "display_short"));
		}};
		A.setAliases(aliasesA);

		List<Alias> aliasesB = new ArrayList<Alias>() {{
			add(new AliasImpl("uniprotkb", "Q9Y6Q6"));
			add(new AliasImpl("uniprotkb", "TNR11_HUMAN"));
			add(new AliasImpl("refseq", "NM_003839"));
			add(new AliasImpl("refseq", "NP_003830"));
			add(new AliasImpl("hgnc", "TNFRSF11A", "display_short"));
		}};
		B.setAliases(aliasesB);

		interactionToCompare.setDetectionMethods(new ArrayList<CrossReference>(
				Collections.singletonList(
						new CrossReferenceImpl("psi-mi", "MI:0007", "anti tag coimmunoprecipitation"))));
		interactionToCompare.setAuthors(new ArrayList<Author>(
				Collections.singletonList(new AuthorImpl("Arron et al. (2001)"))));
		interactionToCompare.setPublications(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("pubmed", "11406619"))));

		Organism organism = new OrganismImpl();
		organism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606", "Human"))));

		A.setOrganism(organism);
		B.setOrganism(organism);


		interactionToCompare.setInteractionTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0915", "physical association"))));
		interactionToCompare.setSourceDatabases(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0974", "innatedb"))));
		interactionToCompare.setInteractionAcs(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDB-113260"))));

		List<Confidence> confidences = new ArrayList<Confidence>() {{
			add(new ConfidenceImpl("lpr", "2"));
			add(new ConfidenceImpl("hpr", "2"));
			add(new ConfidenceImpl("np", "1"));
		}};

		interactionToCompare.setConfidenceValues(confidences);

		// MITAB 2.6
		interactionToCompare.setComplexExpansion(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:1060", "spoke expansion"))));

		A.setBiologicalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0499", "unspecified role"))));
		B.setBiologicalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0499", "unspecified role"))));
		A.setExperimentalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0498", "prey"))));
		B.setExperimentalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0496", "bait"))));
		A.setInteractorTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0326", "protein"))));
		B.setInteractorTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0326", "protein"))));

		A.setXrefs(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("uniprotkb", "D3DRX9", "secondary-ac"))));
		B.setXrefs(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("refseq", "NP_001447.2"))));
		ArrayList<CrossReference> xrefs = new ArrayList<CrossReference>();
		xrefs.add(new CrossReferenceImpl("intact", "EBI-5627041", "see-also"));
		xrefs.add(new CrossReferenceImpl("imex", "IM-17229-3", "imex-primary"));
		interactionToCompare.setXrefs(xrefs);

		List<Annotation> annotations = new ArrayList<Annotation>() {{
			add(new AnnotationImpl("curation depth", "imex curation"));
		}};
		interactionToCompare.setAnnotations(annotations);

		Organism hostOrganism = new OrganismImpl();
		hostOrganism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606"))));

		interactionToCompare.setHostOrganism(hostOrganism);

		List<Parameter> parameters = new ArrayList<Parameter>() {{
			add(new ParameterImpl("kd", "1.36x10^-6", "molar"));
		}};
		interactionToCompare.setParameters(parameters);

		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = formatter.parse("2008/03/30");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		interactionToCompare.setCreationDate(new ArrayList<Date>(
				Collections.singletonList(date)));
		interactionToCompare.setUpdateDate(new ArrayList<Date>(
				Collections.singletonList(date)));

		A.setChecksums(new ArrayList<Checksum>(
				Collections.singletonList(new ChecksumImpl("crc64", "6C1A07041DF50142"))));
		B.setChecksums(new ArrayList<Checksum>(
				Collections.singletonList(new ChecksumImpl("crc64", "2F6FEFCDF2C80457"))));
		interactionToCompare.setChecksums(new ArrayList<Checksum>(
				Collections.singletonList(new ChecksumImpl("intact-crc", "08C4486B755C70C0"))));

		interactionToCompare.setNegativeInteraction(false);

		// MITAB 2.7
		ArrayList<String> rangesA = new ArrayList<String>();
		rangesA.add("2171-2647");
		ArrayList<String> rangesB = new ArrayList<String>();
		rangesB.add("757-800");
		A.setFeatures(new ArrayList<Feature>(
				Collections.singletonList(new FeatureImpl("necessary binding region", rangesA))));
		B.setFeatures(new ArrayList<Feature>(
				Collections.singletonList(new FeatureImpl("necessary binding region", rangesB))));

		A.setParticipantIdentificationMethods(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0363", "inferred by author"))));
		B.setParticipantIdentificationMethods(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0363", "inferred by author"))));

		// MITAB 2.8
		A.setBiologicalEffects(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("go", "GO:0016301", "kinase activity"))));
		B.setBiologicalEffects(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("go", "GO:0016301", "kinase activity"))));

		interactionToCompare.setCausalRegulatoryMechanism(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2249", "post transcriptional regulation"))));
		interactionToCompare.setCausalStatement(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2240", "down regulates"))));

		return interactionToCompare;
	}

	private BinaryInteraction<Interactor> buildIntraIterMoleculeAInteraction() {

		Interactor A = new Interactor();

		BinaryInteraction<Interactor> interactionToCompare = new BinaryInteractionImpl(A, null);

		// MITAB 2.5
		A.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDBG-40102"))));
		A.setAlternativeIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("ensembl", "ENSG00000175104"))));

		List<Alias> aliasesA = new ArrayList<Alias>() {{
			add(new AliasImpl("uniprotkb", "Q9Y4K3"));
		}};
		A.setAliases(aliasesA);

		interactionToCompare.setDetectionMethods(new ArrayList<CrossReference>(
				Collections.singletonList(
						new CrossReferenceImpl("psi-mi", "MI:0007", "anti tag coimmunoprecipitation"))));
		interactionToCompare.setAuthors(new ArrayList<Author>(
				Collections.singletonList(new AuthorImpl("Arron et al. (2001)"))));
		interactionToCompare.setPublications(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("pubmed", "11406619"))));

		Organism organism = new OrganismImpl();
		organism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606", "Human"))));

		A.setOrganism(organism);

		interactionToCompare.setInteractionTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0915", "physical association"))));
		interactionToCompare.setSourceDatabases(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0974", "innatedb"))));
		interactionToCompare.setInteractionAcs(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDB-113260"))));

		List<Confidence> confidences = new ArrayList<Confidence>() {{
			add(new ConfidenceImpl("lpr", "2"));
			add(new ConfidenceImpl("hpr", "2"));
			add(new ConfidenceImpl("np", "1"));
		}};

		interactionToCompare.setConfidenceValues(confidences);

        // MITAB 2.6
        interactionToCompare.setComplexExpansion(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:1060", "spoke expansion"))));

		A.setBiologicalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0499", "unspecified role"))));
		A.setExperimentalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0498", "prey"))));
		A.setInteractorTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0326", "protein"))));

        A.setXrefs(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("uniprotkb", "D3DRX9", "secondary-ac"))));

        ArrayList<CrossReference> xrefs = new ArrayList<CrossReference>();
        xrefs.add(new CrossReferenceImpl("intact", "EBI-5627041", "see-also"));
        xrefs.add(new CrossReferenceImpl("imex", "IM-17229-3", "imex-primary"));
        interactionToCompare.setXrefs(xrefs);

        List<Annotation> annotations = new ArrayList<Annotation>() {{
            add(new AnnotationImpl("curation depth", "imex curation"));
        }};
        interactionToCompare.setAnnotations(annotations);

		Organism hostOrganism = new OrganismImpl();
		hostOrganism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606"))));

		interactionToCompare.setHostOrganism(hostOrganism);

        List<Parameter> parameters = new ArrayList<Parameter>() {{
            add(new ParameterImpl("kd", "1.36x10^-6", "molar"));
        }};
        interactionToCompare.setParameters(parameters);

		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = formatter.parse("2008/03/30");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		interactionToCompare.setCreationDate(new ArrayList<Date>(
				Collections.singletonList(date)));
		interactionToCompare.setUpdateDate(new ArrayList<Date>(
				Collections.singletonList(date)));

        A.setChecksums(new ArrayList<Checksum>(
                Collections.singletonList(new ChecksumImpl("crc64", "6C1A07041DF50142"))));
        interactionToCompare.setChecksums(new ArrayList<Checksum>(
                Collections.singletonList(new ChecksumImpl("intact-crc", "08C4486B755C70C0"))));

		interactionToCompare.setNegativeInteraction(false);

        // MITAB 2.7
        ArrayList<String> rangesA = new ArrayList<String>();
        rangesA.add("2171-2647");
        A.setFeatures(new ArrayList<Feature>(
                Collections.singletonList(new FeatureImpl("necessary binding region", rangesA))));

		A.setStoichiometry(new ArrayList<Integer>(
				Collections.singletonList(new Integer("2"))));

		A.setParticipantIdentificationMethods(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0363", "inferred by author"))));

        // MITAB 2.8
        A.setBiologicalEffects(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("go", "GO:0016301", "kinase activity"))));

        interactionToCompare.setCausalRegulatoryMechanism(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2249", "post transcriptional regulation"))));
        interactionToCompare.setCausalStatement(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2240", "down regulates"))));

		return interactionToCompare;
	}

	private BinaryInteraction<Interactor> buildIntraIterMoleculeBInteraction() {

		Interactor B = new Interactor();

		BinaryInteraction<Interactor> interactionToCompare = new BinaryInteractionImpl(null, B);

		// MITAB 2.5
		B.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDBG-4279"))));
		B.setAlternativeIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("ensembl", "ENSG00000141655"))));

		List<Alias> aliasesB = new ArrayList<Alias>() {{
			add(new AliasImpl("uniprotkb", "Q9Y6Q6"));
		}};
		B.setAliases(aliasesB);

		interactionToCompare.setDetectionMethods(new ArrayList<CrossReference>(
				Collections.singletonList(
						new CrossReferenceImpl("psi-mi", "MI:0007", "anti tag coimmunoprecipitation"))));
		interactionToCompare.setAuthors(new ArrayList<Author>(
				Collections.singletonList(new AuthorImpl("Arron et al. (2001)"))));
		interactionToCompare.setPublications(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("pubmed", "11406619"))));

		Organism organism = new OrganismImpl();
		organism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606", "Human"))));

		B.setOrganism(organism);


		interactionToCompare.setInteractionTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0915", "physical association"))));
		interactionToCompare.setSourceDatabases(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0974", "innatedb"))));
		interactionToCompare.setInteractionAcs(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("innatedb", "IDB-113260"))));

		List<Confidence> confidences = new ArrayList<Confidence>() {{
			add(new ConfidenceImpl("lpr", "2"));
			add(new ConfidenceImpl("hpr", "2"));
			add(new ConfidenceImpl("np", "1"));
		}};

		interactionToCompare.setConfidenceValues(confidences);

        // MITAB 2.6
        interactionToCompare.setComplexExpansion(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:1060", "spoke expansion"))));

		B.setBiologicalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0499", "unspecified role"))));
		B.setExperimentalRoles(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0496", "bait"))));
		B.setInteractorTypes(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0326", "protein"))));

        B.setXrefs(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("refseq", "NP_001447.2"))));
        ArrayList<CrossReference> xrefs = new ArrayList<CrossReference>();

        xrefs.add(new CrossReferenceImpl("intact", "EBI-5627041", "see-also"));
        xrefs.add(new CrossReferenceImpl("imex", "IM-17229-3", "imex-primary"));
        interactionToCompare.setXrefs(xrefs);

        List<Annotation> annotations = new ArrayList<Annotation>() {{
            add(new AnnotationImpl("curation depth", "imex curation"));
        }};
        interactionToCompare.setAnnotations(annotations);

		Organism hostOrganism = new OrganismImpl();
		hostOrganism.setIdentifiers(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("taxid", "9606"))));

		interactionToCompare.setHostOrganism(hostOrganism);

        List<Parameter> parameters = new ArrayList<Parameter>() {{
            add(new ParameterImpl("kd", "1.36x10^-6", "molar"));
        }};
        interactionToCompare.setParameters(parameters);

		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = formatter.parse("2008/03/30");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		interactionToCompare.setCreationDate(new ArrayList<Date>(
				Collections.singletonList(date)));
		interactionToCompare.setUpdateDate(new ArrayList<Date>(
				Collections.singletonList(date)));

        B.setChecksums(new ArrayList<Checksum>(
                Collections.singletonList(new ChecksumImpl("crc64", "2F6FEFCDF2C80457"))));
        interactionToCompare.setChecksums(new ArrayList<Checksum>(
                Collections.singletonList(new ChecksumImpl("intact-crc", "08C4486B755C70C0"))));

		interactionToCompare.setNegativeInteraction(false);

        // MITAB 2.7
        ArrayList<String> rangesB = new ArrayList<String>();
        rangesB.add("757-800");
        B.setFeatures(new ArrayList<Feature>(
                Collections.singletonList(new FeatureImpl("necessary binding region", rangesB))));

        B.setStoichiometry(new ArrayList<Integer>(
				Collections.singletonList(new Integer("2"))));

		B.setParticipantIdentificationMethods(new ArrayList<CrossReference>(
				Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:0363", "inferred by author"))));

        // MITAB 2.8
        B.setBiologicalEffects(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("go", "GO:0016301", "kinase activity"))));

        interactionToCompare.setCausalRegulatoryMechanism(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2249", "post transcriptional regulation"))));
        interactionToCompare.setCausalStatement(new ArrayList<CrossReference>(
                Collections.singletonList(new CrossReferenceImpl("psi-mi", "MI:2240", "down regulates"))));

		return interactionToCompare;
	}

}
