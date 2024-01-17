package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.student;

public class StudentHelperRefactored {

    public enum Grade {
        A, B, C, MAYBE, NO, YES
    }

    public Grade getGrade(int mark, boolean isMaths) {
        final int extraLimit = isMaths ? 5 : 0;

        if (mark > (90 + extraLimit))
            return Grade.A;
        if (mark > (50 + extraLimit))
            return Grade.B;
        return Grade.C;
    }

    public Grade willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
        int extraLimitForMaths = isMaths ? 5 : 0;
        int rejectionLimit = 20;
        int approvalLimit = 80;

        if (marks1 <= rejectionLimit + extraLimitForMaths || marks2 <= rejectionLimit + extraLimitForMaths)
            return Grade.NO;
        if (marks1 >= approvalLimit + extraLimitForMaths || marks2 >= approvalLimit + extraLimitForMaths)
            return Grade.YES;
        return Grade.MAYBE;
    }

    public boolean isGradeB(int marks, boolean isMaths) {
        final int GRADE_B_LWR_LIMIT = 51;
        final int GRADE_B_UPR_LIMIT = 80;

        return marks >= GRADE_B_LWR_LIMIT && marks <= (isMaths ? GRADE_B_UPR_LIMIT + 10 : GRADE_B_UPR_LIMIT);
    }
}