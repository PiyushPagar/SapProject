import React from "react"
import {
    ModalWrapper,
    ModalContainer,
    //Close
} from "./modal"
export default function Modal({ closeModal, children }) {
    return (
        <ModalWrapper>
            {/* <Close src="/assets/Icons/cross.svg" alt="close" onClick={() => closeModal(false)} /> */}
            <ModalContainer >
                {children}
            </ModalContainer>

        </ModalWrapper>
    )
}
