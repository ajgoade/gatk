package org.broadinstitute.hellbender.tools.spark.sv.evidence;

import org.broadinstitute.hellbender.tools.spark.sv.StructuralVariationDiscoveryArgumentCollection;

import java.util.Iterator;

public class BreakpointFilterFactory {
    public static Iterator<BreakpointEvidence> getFilter(
            final Iterator<BreakpointEvidence> evidenceItr,
            final ReadMetadata readMetadata,
            final StructuralVariationDiscoveryArgumentCollection.FindBreakpointEvidenceSparkArgumentCollection params,
            final PartitionCrossingChecker partitionCrossingChecker
    ) {
        switch(params.svEvidenceFilterType) {
            case TWO_THRESHOLD:
                return new BreakpointDensityFilter(
                        evidenceItr, readMetadata, params.minEvidenceWeightPerCoverage, params.minCoherentEvidenceWeightPerCoverage,
                        partitionCrossingChecker, params.minEvidenceMapQ
                );
            case XGBOOST:
                return new XGBoostEvidenceFilter(evidenceItr, readMetadata, params, partitionCrossingChecker);
            default:
                throw new IllegalArgumentException("Unknown svEvidenceFilterType: " + params.svEvidenceFilterType);
        }
    }
}
