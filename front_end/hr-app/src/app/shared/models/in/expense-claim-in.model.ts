import { ExpenseClaimDetailIn } from "./expence-claim-detail-in.model";

export interface ExpenseClaimIn {
    id: string;
    description: string;
    details: ExpenseClaimDetailIn[];
    employee_name: string;
    status: string;
    submission_date: string;
    total: number;
  }