--
-- PostgreSQL database dump
--

-- Dumped from database version 10.15
-- Dumped by pg_dump version 10.15

-- Started on 2022-12-15 22:07:13 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 167150)
-- Name: account; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.account (
    account_id bigint NOT NULL,
    account_number character varying(255) NOT NULL,
    account_type character varying(255),
    inicial_balance numeric(19,2),
    status boolean,
    client_id bigint
);


ALTER TABLE public.account OWNER TO test;

--
-- TOC entry 197 (class 1259 OID 167158)
-- Name: client; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.client (
    client_id bigint NOT NULL,
    address character varying(255),
    age integer,
    gender character varying(255),
    identification character varying(255),
    name character varying(255),
    phone character varying(255),
    password character varying(255),
    status boolean
);


ALTER TABLE public.client OWNER TO test;

--
-- TOC entry 198 (class 1259 OID 167166)
-- Name: id_gen; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.id_gen (
    name_pk character varying(255) NOT NULL,
    value_pk integer
);


ALTER TABLE public.id_gen OWNER TO test;

--
-- TOC entry 199 (class 1259 OID 167171)
-- Name: movement; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.movement (
    movement_id character varying(255) NOT NULL,
    balance numeric(19,2),
    date_movement date,
    description character varying(255),
    movement_type character varying(255),
    value numeric(19,2),
    account_id bigint
);


ALTER TABLE public.movement OWNER TO test;

--
-- TOC entry 2897 (class 0 OID 167150)
-- Dependencies: 196
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.account (account_id, account_number, account_type, inicial_balance, status, client_id) FROM stdin;
\.


--
-- TOC entry 2898 (class 0 OID 167158)
-- Dependencies: 197
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.client (client_id, address, age, gender, identification, name, phone, password, status) FROM stdin;
\.


--
-- TOC entry 2899 (class 0 OID 167166)
-- Dependencies: 198
-- Data for Name: id_gen; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.id_gen (name_pk, value_pk) FROM stdin;
ACCOUNT_ID	1
CLIENT_ID	1
\.


--
-- TOC entry 2900 (class 0 OID 167171)
-- Dependencies: 199
-- Data for Name: movement; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.movement (movement_id, balance, date_movement, description, movement_type, value, account_id) FROM stdin;
\.


--
-- TOC entry 2763 (class 2606 OID 167157)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);


--
-- TOC entry 2767 (class 2606 OID 167165)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);


--
-- TOC entry 2771 (class 2606 OID 167170)
-- Name: id_gen id_gen_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.id_gen
    ADD CONSTRAINT id_gen_pkey PRIMARY KEY (name_pk);


--
-- TOC entry 2773 (class 2606 OID 167178)
-- Name: movement movement_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.movement
    ADD CONSTRAINT movement_pkey PRIMARY KEY (movement_id);


--
-- TOC entry 2765 (class 2606 OID 167180)
-- Name: account uk_66gkcp94endmotfwb8r4ocxm9; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT uk_66gkcp94endmotfwb8r4ocxm9 UNIQUE (account_number);


--
-- TOC entry 2769 (class 2606 OID 167182)
-- Name: client uk_dn5jasds5r1j3ewo5k3nhwkkq; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT uk_dn5jasds5r1j3ewo5k3nhwkkq UNIQUE (name);


--
-- TOC entry 2774 (class 2606 OID 167183)
-- Name: account fkkm8yb63h4ownvnlrbwnadntyn; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fkkm8yb63h4ownvnlrbwnadntyn FOREIGN KEY (client_id) REFERENCES public.client(client_id);


--
-- TOC entry 2775 (class 2606 OID 167188)
-- Name: movement fkoemeananv9w9qnbcoccbl70a0; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.movement
    ADD CONSTRAINT fkoemeananv9w9qnbcoccbl70a0 FOREIGN KEY (account_id) REFERENCES public.account(account_id);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2022-12-15 22:07:14 -05

--
-- PostgreSQL database dump complete
--

