package com.sims.ppob.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ETransactionType {
 PAYMENT("Payment");

 private final String displayName;
}
